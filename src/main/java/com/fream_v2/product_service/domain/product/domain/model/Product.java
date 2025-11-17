package com.fream_v2.product_service.domain.product.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 상품 도메인 모델 (순수 도메인)
 */
@Getter
@Builder
public class Product {
    private final Long productId;
    private final String productName;
    private final String brand;
    private final String category;
    private final String subCategory;
    private final String modelNumber;
    private final String size;
    private final String color;
    private final String description;
    private final ProductCondition condition;
    private final Long retailPrice;
    private final List<String> imageUrls;
    private final Map<String, String> specifications;
    private final ProductStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    /**
     * 상품 생성
     */
    public static Product createProduct(String productName, String brand, String category,
                                        String modelNumber, String size, String color,
                                        String description, ProductCondition condition,
                                        Long retailPrice) {
        return Product.builder()
                .productName(productName)
                .brand(brand)
                .category(category)
                .modelNumber(modelNumber)
                .size(size)
                .color(color)
                .description(description)
                .condition(condition)
                .retailPrice(retailPrice)
                .status(ProductStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 상품 정보 업데이트
     */
    public Product updateInfo(String description, ProductCondition condition,
                              List<String> imageUrls, Map<String, String> specifications) {
        return Product.builder()
                .productId(this.productId)
                .productName(this.productName)
                .brand(this.brand)
                .category(this.category)
                .subCategory(this.subCategory)
                .modelNumber(this.modelNumber)
                .size(this.size)
                .color(this.color)
                .description(description != null ? description : this.description)
                .condition(condition != null ? condition : this.condition)
                .retailPrice(this.retailPrice)
                .imageUrls(imageUrls != null ? imageUrls : this.imageUrls)
                .specifications(specifications != null ? specifications : this.specifications)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 상태 변경
     */
    public Product changeStatus(ProductStatus newStatus) {
        return Product.builder()
                .productId(this.productId)
                .productName(this.productName)
                .brand(this.brand)
                .category(this.category)
                .subCategory(this.subCategory)
                .modelNumber(this.modelNumber)
                .size(this.size)
                .color(this.color)
                .description(this.description)
                .condition(this.condition)
                .retailPrice(this.retailPrice)
                .imageUrls(this.imageUrls)
                .specifications(this.specifications)
                .status(newStatus)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 거래 가능 여부
     */
    public boolean isTradable() {
        return this.status == ProductStatus.ACTIVE;
    }
}