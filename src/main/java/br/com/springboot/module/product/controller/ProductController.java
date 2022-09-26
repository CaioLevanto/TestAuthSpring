package br.com.springboot.module.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.module.product.entities.Product;
import br.com.springboot.module.product.services.ListProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ListProductService listProductService;

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping
  public List<Product> list() {
    return listProductService.listAll();
  }

}