package com.test.Estoque_CRUD_SpringBoot.domain.service;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import com.test.Estoque_CRUD_SpringBoot.domain.repository.ProductRepository;
import com.test.Estoque_CRUD_SpringBoot.mapper.ProductMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private static final Logger log = LoggerFactory.getLogger(ProductService.class);
  private final ProductRepository productRepository;

  @Autowired private ProductMapper productMapper;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> listAllProducts() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    return productRepository.findById(id).get();
  }

  public Product findByName(String name) {
    return productRepository.findByName(name).get();
  }

  public boolean existsByNameIgnoreCase(String name) {
    return productRepository.existsByNameIgnoreCase(name);
  }

  public Product createProduct(Product product) {
    if (product == null) throw new IllegalArgumentException("Produto nao pode ser nulo");
    if (product.getPrice() <= 0)
      throw new IllegalArgumentException("valor de produto deve ser maior que 0");
    if (existsByNameIgnoreCase(product.getName()))
      throw new IllegalArgumentException("Nome já existe");
    product.setLastUpdate(LocalDateTime.now());
    return productRepository.save(product);
  }

  public Product updateProduct(Long id, Product product) {
    Product oldProduct = findById(id);
    product.setLastUpdate(LocalDateTime.now());
    productMapper.mapperProduct(product, oldProduct);
    return productRepository.save(oldProduct);
  }

  public Product updateProductPrice(Long id, Product product) {
    Product existProduct = findById(id);
    existProduct.setPrice(product.getPrice());
    return productRepository.save(existProduct);
  }

  public void deleteProduct(Long id) {
    productRepository.delete(findById(id));
    log.info("Produto Deletado");
  }
}
