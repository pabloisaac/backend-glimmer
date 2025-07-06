package com.glimmer.admin_panel.domain.port.in;

import com.glimmer.admin_panel.domain.model.Category;

import java.util.List;

public interface CategoryServicePort {
    Category create(Category category);
    void delete(String id);
    List<Category> getAll();
}