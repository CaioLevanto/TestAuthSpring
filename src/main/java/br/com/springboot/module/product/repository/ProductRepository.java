package br.com.springboot.module.product.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.module.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}