package com.glimmer.admin_panel.domain.port.out;

import com.glimmer.admin_panel.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findById(String id);
    List<Category> findAll();
    void deleteById(String id);
}