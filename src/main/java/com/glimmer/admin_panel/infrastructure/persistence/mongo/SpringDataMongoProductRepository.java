package com.glimmer.admin_panel.infrastructure.persistence.mongo;

import com.glimmer.admin_panel.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoProductRepository extends MongoRepository<ProductEntity, String> {}