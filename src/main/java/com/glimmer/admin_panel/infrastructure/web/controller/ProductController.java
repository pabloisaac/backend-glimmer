package com.glimmer.admin_panel.infrastructure.web.controller;

import com.glimmer.admin_panel.domain.model.Product;
import com.glimmer.admin_panel.domain.port.in.ProductServicePort;
import com.glimmer.admin_panel.infrastructure.persistence.mapper.ProductMapper;
import com.glimmer.admin_panel.infrastructure.web.dto.ProductCreateDTO;
import com.glimmer.admin_panel.infrastructure.web.dto.ProductDTO;
import com.glimmer.admin_panel.infrastructure.web.dto.ProductUpdateDTO;
import com.glimmer.admin_panel.infrastructure.web.mapper.ProductDTOMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServicePort productService;

    private final ProductDTOMapper productDTOMapper;

    public ProductController(ProductServicePort productService, ProductDTOMapper productDTOMapper) {
        this.productService = productService;
        this.productDTOMapper = productDTOMapper;
    }


    @PostMapping
    public ProductDTO createProduct(@RequestBody @Valid ProductCreateDTO dto) {
        Product product = productDTOMapper.toDomain(dto);
        return productDTOMapper.toDTO(productService.create(product));
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable String id, @RequestBody @Valid ProductUpdateDTO dto) {
        Product productToUpdate = productDTOMapper.toDomain(id, dto);
        Product updated = productService.update(id, productToUpdate);
        return productDTOMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable String id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/low-stock")
    public List<com.glimmer.admin_panel.infrastructure.web.dto.ProductDTO> getLowStock(@RequestParam(defaultValue = "2") int threshold) {
        return productService.getLowStockProducts(threshold)
                .stream()
                .map(productDTOMapper::toDTO)
                .toList();
    }
}