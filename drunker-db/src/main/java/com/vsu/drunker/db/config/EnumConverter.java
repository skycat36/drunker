package com.vsu.drunker.db.config;



import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class EnumConverter implements AttributeConverter<Object, String> {

    private static final String VALUE_SEPARATOR = "@@";

    public static String convertToString(Object o) {
        if (o != null) {
            Class<?> clazz = o.getClass();
            if (clazz.isEnum()) {
                return clazz.getName() + VALUE_SEPARATOR + ((Enum<?>) o).name();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Object convertToEnum(String value) {
        if (StringUtils.isNotBlank(value)) {
            String[] values = value.split(VALUE_SEPARATOR);
            if (values.length == 2) {
                try {
                    Class<?> enumClass = Class.forName(values[0]);
                    if (enumClass.isEnum()) {
                        return convertToEnum(values[1], (Class<Enum<?>>) enumClass);
                    }
                } catch (ClassNotFoundException e) {
                    return null;
                }
            }
        }
        return null;
    }

    public static <T extends Enum<?>> T convertToEnum(String value, Class<T> clazz) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(enumItem -> value.equals(enumItem.name()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String convertToDatabaseColumn(Object o) {
        return convertToString(o);
    }

    @Override
    public Object convertToEntityAttribute(String value) {
        return convertToEnum(value);
    }
}
