package com.product.myproduct.Controllers;

import com.product.myproduct.DTO.FakeStoreDTO;
import com.product.myproduct.Models.Product;
import com.product.myproduct.Services.FakeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fakestore/products")
public class FakeStoreController {
//    @Autowired   //can use autowired or constructor
    FakeStoreService fakeStoreService;

    public FakeStoreController(FakeStoreService fakeStoreService){
        this.fakeStoreService=fakeStoreService;
    }
    @GetMapping("/{id}")
    public FakeStoreDTO getProduct(@PathVariable("id") int id){
        return fakeStoreService.getProduct(id);
    }
    @GetMapping("")
    public List<FakeStoreDTO> getProducts(){
        return fakeStoreService.getProducts();
    }
    @GetMapping("/categories")
    public List<String> getCategories(){
        return fakeStoreService.getCategories();
    }

    @GetMapping("/type/{categoryname}")
    public List<FakeStoreDTO> getProductOfCategory(@PathVariable("categoryname") String categoryname){
        return fakeStoreService.getProductOfCategory(categoryname);
    }
    @PostMapping("")
    public FakeStoreDTO createProduct(@RequestBody FakeStoreDTO product){
        return fakeStoreService.createProduct(product);
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") int id,@RequestBody FakeStoreDTO product){
        return fakeStoreService.updateProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        return fakeStoreService.deleteProduct(id);
    }
}
