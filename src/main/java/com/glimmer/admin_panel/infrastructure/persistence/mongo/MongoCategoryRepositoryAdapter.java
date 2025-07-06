package com.glimmer.admin_panel.infrastructure.persistence.mongo;

import com.glimmer.admin_panel.domain.model.Category;
import com.glimmer.admin_panel.domain.port.out.CategoryRepositoryPort;
import com.glimmer.admin_panel.infrastructure.persistence.entity.CategoryEntity;
import com.glimmer.admin_panel.infrastructure.persistence.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoCategoryRepositoryAdapter implements CategoryRepositoryPort {

    private final SpringDataMongoCategoryRepository repository;
    private final CategoryMapper mapper;

    public MongoCategoryRepositoryAdapter(SpringDataMongoCategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Category save(Category category) {
        return mapper.toDomain(repository.save(mapper.toEntity(category)));
    }

    @Override
    public Optional<Category> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}