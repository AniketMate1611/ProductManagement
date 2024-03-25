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

    @GetMapping("/getproducts/{id}")
    public Product getProduct(@PathVariable("id")int id){
        return productService.getProduct(id);
    }
    @GetMapping("/getproducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PostMapping("/getproducts")
    public String createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @PutMapping("/getproducts/{id}")
    public String updateProduct(@RequestBody Product product,@PathVariable("id")int id){
        return productService.updateProduct(product,id);
    }
    @DeleteMapping("/getproducts/{id}")
    public String deleteProduct(@PathVariable("id")int id){
        return productService.deleteProduct(id);
    }

}
