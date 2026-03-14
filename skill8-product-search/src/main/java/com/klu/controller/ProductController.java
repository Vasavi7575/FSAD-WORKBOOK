package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // /products/category/electronics
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return service.findByCategory(category);
    }

    // /products/filter?min=1000&max=5000
    @GetMapping("/filter")
    public List<Product> filterProducts(@RequestParam double min,
                                        @RequestParam double max){
        return service.filterByPrice(min, max);
    }

    // /products/sorted
    @GetMapping("/sorted")
    public List<Product> sortedProducts(){
        return service.sortByPrice();
    }

    // /products/expensive/5000
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){
        return service.expensiveProducts(price);
    }
}