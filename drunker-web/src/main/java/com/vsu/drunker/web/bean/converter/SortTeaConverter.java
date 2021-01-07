package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.SortTea;
import com.vsu.drunker.web.data.SortTeaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SortTeaConverter {

    @Mapping(target = "id", source = "sortTeaDTO.id")
    @Mapping(target = "name", source = "sortTeaDTO.name")
    @Mapping(target = "kindTeaId", source = "sortTeaDTO.kindId")
    SortTeaDTO convert(SortTea sortTea);

    @Mapping(target = "id", source = "sortTeaDTO.id")
    @Mapping(target = "name", source = "sortTeaDTO.name")
    @Mapping(target = "kindId", source = "sortTeaDTO.kindTeaId")
    SortTea convert(SortTeaDTO sortTeaDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "sortTeaDTO.name")
    @Mapping(target = "kindId", source = "sortTeaDTO.kindTeaId")
    SortTea convert(Long id, SortTeaDTO sortTeaDTO);
}
