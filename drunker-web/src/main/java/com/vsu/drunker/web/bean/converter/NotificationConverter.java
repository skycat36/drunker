package com.vsu.drunker.web.data.converter;


import com.vsu.drunker.db.model.entity.Notification;
import com.vsu.drunker.web.data.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationConverter {

    NotificationDTO convert(Notification role);

    Notification convert(NotificationDTO role);

    @Mapping(target = "id", source = "id")
    Notification convert(Long id, NotificationDTO role);
}
