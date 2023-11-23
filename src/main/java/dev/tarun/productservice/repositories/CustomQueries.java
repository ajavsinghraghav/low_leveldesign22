package dev.tarun.productservice.repositories;

public interface CustomQueries {
    String FIND_ALL_BY_TITLE="select * from product join product_orders" +
                       "on product.id=product_orders.product.id where title=:naman ";
}
