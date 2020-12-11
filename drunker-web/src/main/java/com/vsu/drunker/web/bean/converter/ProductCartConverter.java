package com.vsu.drunker.web.data.converter;

import com.vsu.drunker.data.ProductCartDTO;
import com.vsu.drunker.model.entity.ProductCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductCartConverter {

    ProductCartDTO convert(ProductCart role);

    ProductCart convert(ProductCartDTO role);

    @Mapping(target = "id", source = "id")
    ProductCart convert(Long id, ProductCartDTO role);
}
