package com.glimmer.admin_panel.infrastructure.persistence.mongo;

import com.glimmer.admin_panel.domain.model.Sale;
import com.glimmer.admin_panel.domain.port.out.SaleRepositoryPort;
import com.glimmer.admin_panel.infrastructure.persistence.entity.SaleEntity;
import com.glimmer.admin_panel.infrastructure.persistence.mapper.SaleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoSaleRepositoryAdapter implements SaleRepositoryPort {

    private final SpringDataMongoSaleRepository repository;
    private final SaleMapper mapper;

    public MongoSaleRepositoryAdapter(SpringDataMongoSaleRepository repository, SaleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Sale save(Sale sale) {
        return mapper.toDomain(repository.save(mapper.toEntity(sale)));
    }

    @Override
    public Optional<Sale> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Sale> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}