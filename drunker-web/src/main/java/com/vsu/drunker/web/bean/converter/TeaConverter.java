package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.Tea;
import com.vsu.drunker.web.data.TeaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TeaConverter {

    TeaDTO convert(Tea tea);

    @Mapping(target = "count",ignore = true)
    Tea convert(TeaDTO teaDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    Tea convert(Long id, TeaDTO teaDTO);
}
