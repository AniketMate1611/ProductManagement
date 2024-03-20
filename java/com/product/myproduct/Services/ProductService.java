package com.product.myproduct.Services;

import com.product.myproduct.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Service
public class ProductService {
    Scanner scanner = new Scanner(System.in);
    List<Product> productList = new ArrayList<Product>();
    public Product getProduct(int id){
        if (!productList.isEmpty()) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    return product;
                }
            }
        }else {
            System.out.println("No Such Products Available");
        }
        return null;
    }
    public List<Product> getProducts(){
        if(productList.isEmpty()){
            System.out.println("List is Empty");
            return new ArrayList<>();
        }else {
            System.out.println("Products Fetched Successfully");
            return productList;
        }
    }
    public String createProduct(Product product){
        productList.add(product);
        System.out.println(productList);
        return "Product Added Successfully";
    }
    public String updateProduct(Product product){
        if (!productList.isEmpty()) {
            for (Product prod : productList) {
                if (prod.getId() == product.getId()) {
                    prod.setName(product.getName());
                    prod.setCost(product.getCost());
                    prod.setType(product.getType());
                    return "Product Updated Successfully";
                }
            }
        }
        return "No Such Products Available";
    }
    public String deleteProduct(int id){
        if (!productList.isEmpty()) {
            for (Product product : productList) {
                if (product.getId() ==id) {
                   productList.remove(product);
                    return "Product Deleted Successfully";
                }
            }
        }
        return "No Such Products Available";
    }
}
