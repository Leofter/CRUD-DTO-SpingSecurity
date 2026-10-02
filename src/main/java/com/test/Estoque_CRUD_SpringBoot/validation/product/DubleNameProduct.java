package com.test.Estoque_CRUD_SpringBoot.validation.product;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class DubleNameProduct implements ValidationProduct{

    @Override
    public void validation(Product product) {
        if(product.getName().toLowerCase() == ) throw new DuplicateException("Já existe produto com o mesmo nome") ;
    }
}