package com.glimmer.admin_panel.application.service;

import com.glimmer.admin_panel.domain.model.Category;
import com.glimmer.admin_panel.domain.port.in.CategoryServicePort;
import com.glimmer.admin_panel.domain.port.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryServicePort {

    private final CategoryRepositoryPort categoryRepository;

    public CategoryServiceImpl(CategoryRepositoryPort categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}