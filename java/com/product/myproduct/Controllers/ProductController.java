package com.product.myproduct.Controllers;

import com.product.myproduct.Models.Product;
import com.product.myproduct.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id")int id){
        return productService.getProduct(id);
    }
    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping("")
    public String createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable("id")int id){
        return productService.updateProduct(product,id);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id")int id){
        return productService.deleteProduct(id);
    }

}
