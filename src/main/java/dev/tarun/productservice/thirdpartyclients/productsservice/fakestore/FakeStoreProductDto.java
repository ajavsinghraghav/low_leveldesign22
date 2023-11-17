package dev.tarun.productservice.thirdpartyclients.productsservice.fakestore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
//    //output
//    {
//        id:1,
//                title:'...',
//            price:'...',
//            category:'...',
//            description:'...',
//            image:'...'
//    }
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
