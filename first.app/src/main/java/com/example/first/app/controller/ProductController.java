package com.example.first.app.controller;

import com.example.first.app.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 15 Pro Max", "2024 Mobile Phone", 1000, "Apple"));
        products.add(new Product(2, "Iphone 14 Pro Max", "2023 Mobile Phone", 990, "Apple"));
        products.add(new Product(3, "Iphone 13 Pro Max", "2022 Mobile Phone", 880, "Apple"));
        products.add(new Product(4, "Iphone 12 Pro Max", "2021 Mobile Phone", 770, "Apple"));
        products.add(new Product(5, "Iphone 11 Pro Max", "2020 Mobile Phone", 660, "Apple"));
        products.add(new Product(6, "Galaxy S24 Ultra", "2024 Mobile Phone", 1000, "Samsung"));
        products.add(new Product(7, "Galaxy S23 Ultra", "2023 Mobile Phone", 990, "Samsung"));
        products.add(new Product(8, "Galaxy S22 Ultra", "2022 Mobile Phone", 880, "Samsung"));
        products.add(new Product(9, "Galaxy S21 Ultra", "2021 Mobile Phone", 770, "Samsung"));
        products.add(new Product(10, "Galaxy S20 Ultra", "2020 Mobile Phone", 660, "Samsung"));
    }

    @GetMapping
    public List<Product> getAllProducts() {return products;}

    @GetMapping("/{id}")
    public Product getProductsById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
