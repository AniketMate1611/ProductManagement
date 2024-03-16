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
    public Product getProduct(){
        System.out.println("Enter id of product you want to fetch:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
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
    public Product createProduct(){
        Product product = new Product();
        System.out.println("Enter id, name, cost, and type of product:");
        System.out.print("ID: ");
        product.setId(scanner.nextInt());
        System.out.print("Name: ");
        product.setName(scanner.next());
        System.out.print("Cost: ");
        product.setCost(scanner.nextDouble());
        System.out.print("Type: ");
        product.setType(scanner.next());
        productList.add(product);
        System.out.println("Product Added Successfully");

        return product;
    }
    public String updateProduct(){
        System.out.println("Enter id of product you want to Update:");
        System.out.print("ID: ");
        int id = scanner.nextInt();

        if (!productList.isEmpty()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getId() == id) {
                    System.out.print("Name: ");
                    product.setName(scanner.next());
                    System.out.print("Cost: ");
                    product.setCost(scanner.nextDouble());
                    System.out.print("Type: ");
                    product.setType(scanner.next());
                    System.out.println("Product Updated Successfully");
                    return "Product Updated Successfully";
                }
            }
            System.out.println("No Such Product Available");
            return "No Such Product Available";
        } else {
            System.out.println("No Such Product Available");
            return "No Products Available";
        }

    }
    public String deleteProduct(){
        System.out.println("Enter id of product you want to Delete:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        if (!productList.isEmpty()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getId() == id) {
                    iterator.remove();
                    System.out.println("Product Deleted Successfully");
                    return "Product Deleted Successfully";
                }
            }
            System.out.println("No Such Product Available");
            return "No Such Product Available";
        } else {
            System.out.println("No Such Product Available");
            return "No Products Available";
        }
    }
}
