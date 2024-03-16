package com.product.myproduct.Controllers;

import com.product.myproduct.Models.Product;
import com.product.myproduct.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getone")
    public Product getProduct(){
        return productService.getProduct();
    }
    @GetMapping("/getall")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping("/create")
    public Product createProduct(){
        return productService.createProduct();
    }
    @PutMapping("update")
    public String updateProduct(){
        return productService.updateProduct();
    }
    @DeleteMapping("/delete")
    public String deleteProduct(){
        return productService.deleteProduct();
    }

}
