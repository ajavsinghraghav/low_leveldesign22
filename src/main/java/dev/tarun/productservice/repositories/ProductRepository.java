package dev.tarun.productservice.repositories;

import dev.tarun.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

     Product findByTitleEquals(String title);

   Product findByTitleEqualsAndPrice_Price(String title,double Price);

    Product findByTitleEqualsAndPrice_PriceOrderByPrice_Price(String title,double Price);
    List<Product> findAllByPrice_Currency(String Currency);


    long countAllByPrice_Currency(String Currency);//count number of products having this currency

    long countDistinctByPrice_Currency(String Currency);//count number of distinct products having this currency

    List<Product> findAllByTitleLike(String titleRegex);

    @Query(value=CustomQueries.FIND_ALL_BY_TITLE,nativeQuery = true) //So that if we are using postgresql query , we just
    List<Product> findAllByTitle(String naman);              //just have to change one file i.e. CustomQueries
    //solution of above issue is using hibernate query

    @Query("select Product from Product where Product.price.currency=:currency and Product.title=:naman") //hibernate query
    List<Product> readAllByTitle(String naman);

    //very imp-
    //hibernate query will be check in compile time but native query will be check in run time

}
