package com.product.myproduct.Services;

import com.product.myproduct.Models.Product;
import com.product.myproduct.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product getProduct(int id){
        Optional<Product> optional =productRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        Product p = new Product();
        p.setId(0);
        p.setName("");
        p.setCost(0);
        p.setType("");
        return p;
    }
    public List<Product> getProducts(){
       return productRepository.findAll();
    }
    public String createProduct(Product product){
     productRepository.save(product);
     return "Product Added Successfully";
    }
    public Product updateProduct(Product product, int id){
        Optional<Product> optional= productRepository.findById(id);
        if(optional.isPresent()){
            Product newProduct = new Product();
            newProduct.setName(product.getName());
            newProduct.setCost(product.getCost());
            newProduct.setType(product.getType());
            return productRepository.save(newProduct);
        }
        else{
            return productRepository.save(product);
        }
    }
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed SuccessFully";
    }
}
