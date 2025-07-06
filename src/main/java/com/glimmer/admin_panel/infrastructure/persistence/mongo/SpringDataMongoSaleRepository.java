package com.glimmer.admin_panel.infrastructure.persistence.mongo;

import com.glimmer.admin_panel.infrastructure.persistence.entity.SaleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoSaleRepository extends MongoRepository<SaleEntity, String> {
}