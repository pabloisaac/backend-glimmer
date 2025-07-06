package com.glimmer.admin_panel.infrastructure.persistence.mongo;

import com.glimmer.admin_panel.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoCategoryRepository extends MongoRepository<CategoryEntity, String> {
}