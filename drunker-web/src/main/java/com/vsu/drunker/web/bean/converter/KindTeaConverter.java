package com.vsu.drunker.web.data.converter;

import com.vsu.drunker.data.KindTeaDTO;
import com.vsu.drunker.model.entity.KindTea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KindTeaConverter {

    KindTeaDTO convert(KindTea role);

    KindTea convert(KindTeaDTO role);

    @Mapping(target = "id", source = "id")
    KindTea convert(Long id, KindTeaDTO role);
}
