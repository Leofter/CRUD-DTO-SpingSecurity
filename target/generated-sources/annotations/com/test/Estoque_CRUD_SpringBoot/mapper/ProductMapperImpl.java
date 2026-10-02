package com.test.Estoque_CRUD_SpringBoot.mapper;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-01T10:18:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public void mapperProduct(Product newProduct, Product oldProduct) {
        if ( newProduct == null ) {
            return;
        }

        if ( newProduct.getId() != null ) {
            oldProduct.setId( newProduct.getId() );
        }
        if ( newProduct.getName() != null ) {
            oldProduct.setName( newProduct.getName() );
        }
        if ( newProduct.getDescription() != null ) {
            oldProduct.setDescription( newProduct.getDescription() );
        }
        if ( newProduct.getPrice() != null ) {
            oldProduct.setPrice( newProduct.getPrice() );
        }
        if ( newProduct.getAmount() != null ) {
            oldProduct.setAmount( newProduct.getAmount() );
        }
        if ( newProduct.getLastUpdate() != null ) {
            oldProduct.setLastUpdate( newProduct.getLastUpdate() );
        }
    }
}
