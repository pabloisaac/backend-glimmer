package com.glimmer.admin_panel.domain.port.in;

public interface PriceAdjustmentServicePort {
    void applyAdjustment(String scope, String categoryId, String productId, double margin, double discountCash, double discountTransfer);
}