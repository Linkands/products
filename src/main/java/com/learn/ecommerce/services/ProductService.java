package com.learn.ecommerce.services;

import com.learn.ecommerce.entities.ProductEntity;
import com.learn.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException("product with ID " + id + " not found");
        }
    }

    public ProductEntity addNewProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setName(updatedProduct.getName());
            product.get().setPrice(updatedProduct.getPrice());
            product.get().setDescription(updatedProduct.getDescription());
            return productRepository.save(product.get());
        } else {
            throw new RuntimeException("product with ID " + id + " not found");
        }
    }

    public ProductEntity deleteProduct(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return product.get();
        } else {
            throw new RuntimeException("product with ID " + id + " not found");
        }
    }
}
