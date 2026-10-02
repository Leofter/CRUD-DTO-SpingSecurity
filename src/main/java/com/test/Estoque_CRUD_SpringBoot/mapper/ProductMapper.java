package com.test.Estoque_CRUD_SpringBoot.mapper;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    void mapperProduct(Product newProduct, @MappingTarget Product oldProduct);
}
