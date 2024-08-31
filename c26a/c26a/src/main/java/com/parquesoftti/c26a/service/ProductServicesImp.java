package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Product;
import com.parquesoftti.c26a.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServicesImp implements ProductService{


    final ProductRepository ProductRepository;

    @Override
    public List<Product> findAll() {
        return ProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return ProductRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public Product update(Long id, Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public void delete(Long id) {
        ProductRepository.deleteById(id);
    }
}