package com.vsu.drunker.web.bean.converter;

import com.vsu.drunker.db.model.entity.ProductCart;
import com.vsu.drunker.web.data.ProductCartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductCartConverter {

    ProductCartDTO convert(ProductCart role);

    @Mapping(target = "count",ignore = true)
    ProductCart convert(ProductCartDTO role);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "count",ignore = true)
    ProductCart convert(Long id, ProductCartDTO role);
}
