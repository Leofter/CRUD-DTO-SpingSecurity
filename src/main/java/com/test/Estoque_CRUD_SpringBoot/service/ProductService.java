package com.test.Estoque_CRUD_SpringBoot.service;

import com.test.Estoque_CRUD_SpringBoot.domain.Product;
import com.test.Estoque_CRUD_SpringBoot.mapper.ProductMapper;
import com.test.Estoque_CRUD_SpringBoot.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        if(product==null) throw new IllegalArgumentException("Produto nao pode ser nulo");
        product.setLastUpdate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }


    public Product updateProduct(Long id, Product newProduct){
        Product oldProduct = findById(id);
        newProduct.setLastUpdate(LocalDateTime.now());
        productMapper.maperProduct(newProduct, oldProduct);
        return productRepository.save(oldProduct);
    }

    public void deleteProduct(Long id){
        productRepository.delete(findById(id));
        log.info("Produto Deletado");
    }


}

