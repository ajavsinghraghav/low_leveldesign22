package dev.tarun.productservice.services;

import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.models.Product;
import dev.tarun.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
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
