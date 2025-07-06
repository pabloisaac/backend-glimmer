package com.glimmer.admin_panel.infrastructure.web.controller;

import com.glimmer.admin_panel.domain.model.Category;
import com.glimmer.admin_panel.domain.port.in.CategoryServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Categories", description = "Gestión de categorías de productos")
public class CategoryController {

    private final CategoryServicePort categoryService;

    public CategoryController(CategoryServicePort categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}