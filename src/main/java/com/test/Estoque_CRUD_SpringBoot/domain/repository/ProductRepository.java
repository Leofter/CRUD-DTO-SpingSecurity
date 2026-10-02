package com.test.Estoque_CRUD_SpringBoot.domain.repository;

import com.test.Estoque_CRUD_SpringBoot.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
