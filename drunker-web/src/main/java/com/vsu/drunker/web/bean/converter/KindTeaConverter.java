package com.vsu.drunker.web.bean.converter;


import com.vsu.drunker.db.model.entity.KindTea;
import com.vsu.drunker.web.data.KindTeaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface KindTeaConverter {

    KindTeaDTO convert(KindTea role);

    @Mapping(target = "count",ignore = true)
    KindTea convert(KindTeaDTO role);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    KindTea convert(Long id, KindTeaDTO role);
}
