package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findByCategory(String category){
        return repository.findByCategory(category);
    }

    public List<Product> filterByPrice(double min, double max){
        return repository.findByPriceBetween(min, max);
    }

    public List<Product> sortByPrice(){
        return repository.getProductsSortedByPrice();
    }

    public List<Product> expensiveProducts(double price){
        return repository.getExpensiveProducts(price);
    }
}