package com.glimmer.admin_panel.infrastructure.persistence.mongo;

import com.glimmer.admin_panel.domain.model.Product;
import com.glimmer.admin_panel.domain.port.out.ProductRepositoryPort;
import com.glimmer.admin_panel.infrastructure.persistence.entity.ProductEntity;
import com.glimmer.admin_panel.infrastructure.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoProductRepositoryAdapter implements ProductRepositoryPort {

    private final SpringDataMongoProductRepository repository;
    private final ProductMapper mapper;

    public MongoProductRepositoryAdapter(SpringDataMongoProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Product> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}