package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.Role;
import com.vsu.drunker.web.data.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoleConverter {

    RoleDTO convert(Role role);

    Role convert(RoleDTO role);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    Role convert(Long id, RoleDTO role);
}
