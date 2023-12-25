package dev.tarun.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//functional test//i.e. based on user,what user want//user care about what it has sent and what it is receiving
//WebMvcTest annotation not initialize any unnecessary bean
//@WebMvcTest(ProductController.class) will only initialize dependencies that can be reached from Product Controller
//WebMvcTest not even initialising the server,it will just initialise the dependent class beans
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());
        mockMvc.
                perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }
    @Test
    void returnsListOfProductsWhenProductsExist() throws Exception {
        ArrayList<GenericProductDto> products = new ArrayList<>();
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());

        when(
                productService.getAllProducts()
        ).thenReturn(
                products
        );

        mockMvc.perform(
                get("/products")
        ).andExpect(
                status().is(200)
        ).andExpect(
                content().string(objectMapper.writeValueAsString(products))
        );
        //it means:- when you will perform this particular request// you should expect that the status code should return 200
        //and the body that you will get in the response should be the json representation of the list in string format
    }
    @Test
    void createProductShouldCreateANewProduct() throws Exception {
        GenericProductDto productToCreate = new GenericProductDto();
        productToCreate.setTitle("iPhone 15 Pro Max");
        productToCreate.setImage("some image");
        productToCreate.setCategory("mobile phones");
        productToCreate.setDescription("Best iPhone Ever");

        GenericProductDto expectedProduct = new GenericProductDto();
        expectedProduct.setId(1001L);
        expectedProduct.setTitle("iPhone 15 Pro Max");
        expectedProduct.setImage("some image");
        expectedProduct.setCategory("mobile phones");
        expectedProduct.setDescription("Best iPhone Ever");

        when(
                productService.createProduct(any())
        ).thenReturn(
                expectedProduct
        );

        mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToCreate))
                )
                .andExpect(
                        content().string(objectMapper.writeValueAsString(expectedProduct))
                );


    }
}

//object Mapper is used to convert a java object to a json format
//diff b/w springbootTest and webMvcTest
//springbootTest creates the complete springboot context, it loads all of the application file, starts the application server,
//it create all of the dependencies, it takes a lot of time to start up
//WebMVC test allows you to do the same in a very light weight manner//only initializes the dependencies that are needed to run
//basically the dependencies of the given controller or any class that you will put inside the test cases
//webmvcTest specializes on performing test cases that are going to sent http request,
// basically testing the functionality of the application
