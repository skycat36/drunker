package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.User;
import com.vsu.drunker.web.data.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDTO convert(User user);

    @Mapping(target = "count",ignore = true)
    User convert(UserDTO userDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    User convert(Long id, UserDTO userDTO);
}
