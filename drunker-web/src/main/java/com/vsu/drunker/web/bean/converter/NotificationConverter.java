package com.vsu.drunker.web.bean.converter;


import com.vsu.drunker.db.model.entity.Notification;
import com.vsu.drunker.web.data.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface NotificationConverter {

    NotificationDTO convert(Notification role);

    @Mapping(target = "count",ignore = true)
    Notification convert(NotificationDTO role);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    Notification convert(Long id, NotificationDTO role);
}
