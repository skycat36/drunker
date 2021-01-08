package com.vsu.drunker.db.model.repository.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@RequiredArgsConstructor
public abstract class BaseSpecification<T, F extends JpaSpecificationExecutor<T>> {

    private final F f;

    public List<T> getPremiumProducts(Field field, String name, List<String> categories) {
        return f.findAll(
                where(belongsTo(field, categories))
                        .and(nameLikeField(field, name)));
    }

    public Specification<T> belongsTo(Field field, List<String> search){
        return (root, query, criteriaBuilder)-> criteriaBuilder.in(root.get(field.getName())).value(search);
    }

    public Specification<T> nameLikeField(Field fieldName, String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(fieldName.getName()), "%"+name+"%");
    }

    protected Object castToRequiredType(Class fieldType, String value) {
        if(fieldType.isAssignableFrom(Double.class)){
            return Double.valueOf(value);
        }else if(fieldType.isAssignableFrom(Integer.class)){
            return Integer.valueOf(value);
        }else if(Enum.class.isAssignableFrom(fieldType)){
            return Enum.valueOf(fieldType, value);
        }
        return null;
    }

    protected Object castToRequiredType(Class fieldType, List<String> value) {
        List<Object> lists = new ArrayList<>();
        for (String s : value) {
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }

}
