package dev.tarun.productservice.services;

import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id){
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
    @Override
    public GenericProductDto deleteProduct(Long id){
        return null;
    }

}
