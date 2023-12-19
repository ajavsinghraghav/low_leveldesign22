package dev.tarun.productservice.services;

import dev.tarun.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.exceptions.NotFoundException;
import dev.tarun.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Primary //if there are two conflicting instances of that particaular thing, use this particular instance
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    //in new feature of springboot , you don't need to use @AUTOWIRE above constructor,
    // spring will automatically understand this
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;
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
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        System.out.println("In FakeStoreProductService");
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductServiceClient.getAllProducts()){
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(id));
    }

}
