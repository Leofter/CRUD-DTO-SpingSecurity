package com.test.Estoque_CRUD_SpringBoot.api.controller;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import com.test.Estoque_CRUD_SpringBoot.domain.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class ProductController {

  @Autowired private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> createProduct(@Valid @RequestBody Product p) {
    return ResponseEntity.ok(productService.createProduct(p));
  }

  @GetMapping
  public List<Product> listAllProducts() {
    return productService.listAllProducts();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.findById(id));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable Long id, @RequestBody Product product) {
    return ResponseEntity.ok(productService.updateProduct(id, product));
  }

  @PatchMapping("/{id}/price")
  public ResponseEntity<Product> updateProductPrice(
      @PathVariable Long id, @RequestBody Product product) {
    return ResponseEntity.ok(productService.updateProductPrice(id, product));
  }

  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}
