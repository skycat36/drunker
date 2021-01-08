package com.vsu.drunker.web.bean.converter;


import com.vsu.drunker.db.model.entity.KindTea;
import com.vsu.drunker.web.data.KindTeaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface KindTeaConverter {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    KindTeaDTO convert(KindTea kindTeaDTO);

    @Mapping(target = "name", source = "name")
    KindTea convert(KindTeaDTO kindTeaDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "kindTeaDTO.name")
    @Mapping(target = "count",ignore = true)
    KindTea convert(Long id, KindTeaDTO kindTeaDTO);
}
