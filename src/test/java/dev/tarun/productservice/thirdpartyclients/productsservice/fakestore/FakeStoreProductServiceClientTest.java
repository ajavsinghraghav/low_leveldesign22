package dev.tarun.productservice.thirdpartyclients.productsservice.fakestore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FakeStoreProductServiceClientTest {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Test
    void testNonExistingProductReturnsNull(){  //integration test//calling thirdParty APi

//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response=
//                restTemplate.getForEntity(specificProductRequestURL, FakeStoreProductDto.class,id);
//        //I want to send a get request at given URL
//        FakeStoreProductDto fakeStoreProductDto= response.getBody();
//        assertNull(fakeStoreProductDto);

    }

}