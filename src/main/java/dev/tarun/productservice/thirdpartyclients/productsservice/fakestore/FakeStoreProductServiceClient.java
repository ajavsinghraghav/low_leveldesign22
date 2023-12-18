package dev.tarun.productservice.thirdpartyclients.productsservice.fakestore;

import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductServiceClient{
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;

    private String specificProductRequestURL; //gotten from third party API
    private String ProductRequestsBaseURL;
    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakestore.api.url}")String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath){
        this.restTemplateBuilder=restTemplateBuilder;
        this.ProductRequestsBaseURL=fakeStoreApiUrl+fakeStoreProductsApiPath;
        this.specificProductRequestURL=fakeStoreApiUrl+fakeStoreProductsApiPath+"/{id}";
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product=new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.getForEntity(specificProductRequestURL, FakeStoreProductDto.class,id);
        //I want to send a get request at given URL
        FakeStoreProductDto fakeStoreProductDto= response.getBody();

        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id : "+id+" doesn't exist");
        }
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.postForEntity(ProductRequestsBaseURL,product,FakeStoreProductDto.class);

        return response.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=
                restTemplate.getForEntity(ProductRequestsBaseURL,FakeStoreProductDto[].class);

        List<GenericProductDto> answer=new ArrayList<>();
        return Arrays.stream(response.getBody()).toList();
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        //next 3 line taken from RestTemplate.java line no. 404-405 from getForEntity
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.execute(specificProductRequestURL, HttpMethod.DELETE, requestCallback, responseExtractor,id);

        return response.getBody();
    }

}
