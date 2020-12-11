package com.vsu.drunker.web.data.converter;

import com.vsu.drunker.data.TeaDTO;
import com.vsu.drunker.model.entity.Tea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeaConverter {

    TeaDTO convert(Tea role);

    Tea convert(TeaDTO role);

    @Mapping(target = "id", source = "id")
    Tea convert(Long id, TeaDTO role);
}
