package dev.tarun.productservice.services;

import dev.tarun.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(String uuid);
    //List<String> getProductTitles(List<String> categoryUUIDs);
}
