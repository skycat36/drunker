package com.vsu.drunker.web.data.converter;

import com.vsu.drunker.data.UserDTO;
import com.vsu.drunker.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

    UserDTO convert(User user);

    User convert(UserDTO userDTO);

    @Mapping(target = "id", source = "id")
    User convert(Long id, UserDTO userDTO);
}
