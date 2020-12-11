package com.vsu.drunker.web.data.converter;

import com.vsu.drunker.data.RoleDTO;
import com.vsu.drunker.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoleConverter {

    RoleDTO convert(Role role);

    Role convert(RoleDTO role);

    @Mapping(target = "id", source = "id")
    Role convert(Long id, RoleDTO role);
}
