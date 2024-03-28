package com.product.myproduct.Services;

import com.product.myproduct.DTO.FakeStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreService {
    @Autowired
    RestTemplate restTemplate;


    public FakeStoreDTO getProduct(int id) {
        ResponseEntity<FakeStoreDTO> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/"+id,FakeStoreDTO.class);
        FakeStoreDTO fakeStoreDTO = responseEntity.getBody();
        return fakeStoreDTO;
    }

    public List<FakeStoreDTO> getProducts() {
       ResponseEntity<FakeStoreDTO[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreDTO[].class);
        FakeStoreDTO[] productsArray = responseEntity.getBody();
        if(productsArray != null){
            return Arrays.asList(productsArray);
        }
        else {
            return new ArrayList<>();
        }

    }
    public List<FakeStoreDTO> getProductOfCategory(String categoryname) {
        ResponseEntity<FakeStoreDTO[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/category/"+categoryname,FakeStoreDTO[].class);
        FakeStoreDTO[] productsArray = responseEntity.getBody();
        if(productsArray != null){
            return Arrays.asList(productsArray);
        }
        else {
            return new ArrayList<>();
        }

    }

    public FakeStoreDTO createProduct(FakeStoreDTO product) {
       ResponseEntity<FakeStoreDTO> responseEntity= restTemplate.postForEntity("https://fakestoreapi.com/products",product,FakeStoreDTO.class);
       FakeStoreDTO fakeStoreDTO =responseEntity.getBody();
        return fakeStoreDTO;
    }

    public List<String> getCategories() {
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",String[].class);
        String[] categoryArray = responseEntity.getBody();
        if(categoryArray != null){
            return Arrays.asList(categoryArray);
        }
        else {
            return new ArrayList<>();
        }
    }

    public String updateProduct(int id,FakeStoreDTO product) {
        restTemplate.put("https://fakestoreapi.com/products/"+id,product);
        return "Product Updated SuccessFully";
    }

    public String deleteProduct(int id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return "Product Deleted SuccessFully";
    }
}
