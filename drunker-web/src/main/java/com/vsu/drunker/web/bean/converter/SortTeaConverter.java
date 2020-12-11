package com.vsu.drunker.web.data.converter;

import com.vsu.drunker.data.SortTeaDTO;
import com.vsu.drunker.model.entity.SortTea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SortTeaConverter {

    SortTeaDTO convert(SortTea role);

    SortTea convert(SortTeaDTO role);

    @Mapping(target = "id", source = "id")
    SortTea convert(Long id, SortTeaDTO role);
}
