package com.glimmer.admin_panel.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("categories")
public class CategoryEntity {
    @Id
    private String id;
    private String name;
    private String description;
}