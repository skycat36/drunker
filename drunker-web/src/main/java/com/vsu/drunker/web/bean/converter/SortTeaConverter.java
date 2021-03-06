package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.SortTea;
import com.vsu.drunker.web.data.SortTeaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SortTeaConverter {

    @Mapping(target = "id", source = "sortTea.id")
    @Mapping(target = "name", source = "sortTea.name")
    SortTeaDTO convert(SortTea sortTea);

    @Mapping(target = "id", source = "sortTeaDTO.id")
    @Mapping(target = "name", source = "sortTeaDTO.name")
    SortTea convert(SortTeaDTO sortTeaDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "sortTeaDTO.name")
    SortTea convert(Long id, SortTeaDTO sortTeaDTO);
}
