package dev.tarun.productservice.repositories;

import dev.tarun.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PriceRepository extends JpaRepository<Price,Long> {
}
