package com.product.myproduct.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDTO {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
}
