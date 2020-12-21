package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.SortTea;
import com.vsu.drunker.web.data.SortTeaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SortTeaConverter {

    SortTeaDTO convert(SortTea role);

    @Mapping(target = "count",ignore = true)
    SortTea convert(SortTeaDTO role);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    SortTea convert(Long id, SortTeaDTO role);
}
