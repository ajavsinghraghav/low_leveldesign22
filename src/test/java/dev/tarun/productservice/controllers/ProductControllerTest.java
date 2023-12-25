package dev.tarun.productservice.controllers;

import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.exceptions.NotFoundException;
import dev.tarun.productservice.services.ProductService;
import dev.tarun.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
public class ProductControllerTest {
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @Captor
    private ArgumentCaptor<Long> idCaptor;
//    @Test
//    void returnsNullWhenProductDoesntExist() throws NotFoundException{
//        GenericProductDto genericProductDto=productController.getProductById(121L);
//        //hardcoded what productsService returning , because ProductService was not returning null(as expecting),it is returning GenericProductDto Object
//        //when(productService.getProductById(121L)).thenReturn(null);
//        //when(productService.getProductById(121L)).thenReturn(any(Long.class));
//        //when(productService.getProductById(121L)).thenReturn(new GenericProductDto());
//        assertNull(genericProductDto);
//    }
    @Test
    void throwsExceptionWhenProductDoesntExist() throws NotFoundException {
        when(
                productService.getProductById(any(Long.class))
        ).thenReturn(null);
        assertThrows(NotFoundException.class,()->productController.getProductById(123L));
    }
    @Test
    void returnSameProductAsService() throws NotFoundException {
        GenericProductDto genericProductDto=new GenericProductDto();
        when(
                productService.getProductById(any(Long.class))
        )
                .thenReturn(genericProductDto);
        assertEquals(genericProductDto,productController.getProductById(123L));
    }
    @Test
    @DisplayName("1+1 equals 2")
    void onePlusOneEqualsTrue(){
//        System.out.println("It is true");
//        assertEquals(11,1+1,"one plus is not coming to be 11");
//        assertNull(fakeStoreProductServiceClient.getProductById(101L));
//      assertThrows(NotFoundException.class,()->FakeStoreProductServiceClient.getProductById(121L));
    }
    @Test
    void additionShouldBeCorrect(){
        assertTrue(-1-1==-2,"adding 2 negatives is not correct");
        assertTrue(-1+0==-1,"adding negative and a zero is giving wrong answer");
        assertFalse(-1+1==0,"");
    }
        @Test
    void productControllerCallsProductServiceWithSameProductId() throws NotFoundException {
        Long id = 101L;

        when(productService.getProductById(any()))
                .thenReturn(new GenericProductDto());

        // check that the product service is being called with the exact same
        // param as controller

        productController.getProductById(id);

        verify(productService).getProductById(idCaptor.capture());
        assertEquals(id, idCaptor.getValue());
    }
}
//            when(fakeStoryProductServiceClient.getProductById(any()))
//                    .thenCallRealMethod();

//        when(fakeStoreProductService.getProductById(any()))
//                .thenCallRealMethod();
//        verify(fakeStoryProductServiceClient).getProductById(fakeStoreCaptor.capture());
//        assertEquals(id, fakeStoreCaptor.getValue());
