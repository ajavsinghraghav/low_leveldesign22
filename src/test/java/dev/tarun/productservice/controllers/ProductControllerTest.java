package dev.tarun.productservice.controllers;

import dev.tarun.productservice.exceptions.NotFoundException;
import dev.tarun.productservice.services.FakeStoreProductService;
import dev.tarun.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.NoTransactionException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductControllerTest {
//    @Autowired
//    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    @Test
    @DisplayName("1+1 equals 2")
    void onePlusOneEqualsTrue(){
//        System.out.println("It is true");
//        assertEquals(11,1+1,"one plus is not coming to be 11");
//        assertNull(fakeStoreProductServiceClient.getProductById(101L));
//        assertThrows(NotFoundException.class,()->FakeStoreProductServiceClient.getProductById(101L));
    }
    @Test
    void additionShouldBeCorrect(){
        assertTrue(-1-1==-2,"adding 2 negatives is not correct");
        assertTrue(-1+0==-1,"adding negative and a zero is giving wrong answer");
        assertFalse(-1+1==0,"");
    }
}
