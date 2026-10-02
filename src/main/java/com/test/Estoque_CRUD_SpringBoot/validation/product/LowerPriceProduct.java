package com.test.Estoque_CRUD_SpringBoot.validation.product;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class LowerPriceProduct implements ValidationProduct{
    @Override
    public void validation(Product product) {
        if(product.getPrice() <= 0) throw new PriceException("valor de produto deve ser maior que 0");
    }
}
