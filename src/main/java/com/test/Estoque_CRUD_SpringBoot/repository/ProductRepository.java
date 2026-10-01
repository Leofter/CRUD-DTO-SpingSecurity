package com.test.Estoque_CRUD_SpringBoot.repository;

import com.test.Estoque_CRUD_SpringBoot.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
