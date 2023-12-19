package dev.tarun.productservice.controllers;

import dev.tarun.productservice.dtos.ExceptionDto;
import dev.tarun.productservice.dtos.GenericProductDto;
import dev.tarun.productservice.exceptions.NotFoundException;
import dev.tarun.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //    @Autowired
    // field injection
    private ProductService productService;


    // constructor injection
//    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }
    //

    // setter injection
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id")Long id) throws NotFoundException{
        GenericProductDto productDto=productService.getProductById(id);
        if(productDto==null){
           throw new NotFoundException("Product Doesn't Exist");
        }
//        //created case for failing returnSameProductAsService method in ProductControllerTest
//        GenericProductDto genericProductDto=new GenericProductDto();
//        genericProductDto.setTitle(productDto.getTitle());
//        return genericProductDto;
        return productDto ;
    }
    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id")Long id){

        return  new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.NOT_FOUND);   //example for showing that we can change the status in postman as well
        //otherwise it will be done by spring dispatcher
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
      return productService.createProduct(product);
    }
    @PutMapping("{id}")
    public void updateProductById(){

    }
}
