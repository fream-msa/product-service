package com.fream_v2.product_service.domain.product.infrastructure.persistence.entity;

import com.fream_v2.product_service.domain.product.domain.model.Product;
import com.fream_v2.product_service.domain.product.domain.model.ProductCondition;
import com.fream_v2.product_service.domain.product.domain.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 상품 엔티티 (Infrastructure Layer)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("products")
public class ProductEntity {
    @Id
    private Long id;
    private String productName;
    private String brand;
    private String category;
    private String subCategory;
    private String modelNumber;
    private String size;
    private String color;
    private String description;
    private String condition;
    private Long retailPrice;
    private String imageUrls; // JSON 배열로 저장
    private String specifications; // JSON 객체로 저장
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * 도메인 모델로 변환
     */
    public Product toDomain() {
        return Product.builder()
                .productId(this.id)
                .productName(this.productName)
                .brand(this.brand)
                .category(this.category)
                .subCategory(this.subCategory)
                .modelNumber(this.modelNumber)
                .size(this.size)
                .color(this.color)
                .description(this.description)
                .condition(ProductCondition.valueOf(this.condition))
                .retailPrice(this.retailPrice)
                .imageUrls(parseImageUrls(this.imageUrls))
                .specifications(parseSpecifications(this.specifications))
                .status(ProductStatus.valueOf(this.status))
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성 (신규)
     */
    public static ProductEntity fromDomain(Product product) {
        return ProductEntity.builder()
                .productName(product.getProductName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .subCategory(product.getSubCategory())
                .modelNumber(product.getModelNumber())
                .size(product.getSize())
                .color(product.getColor())
                .description(product.getDescription())
                .condition(product.getCondition().name())
                .retailPrice(product.getRetailPrice())
                .imageUrls(toJsonArray(product.getImageUrls()))
                .specifications(toJsonObject(product.getSpecifications()))
                .status(product.getStatus().name())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 업데이트 (기존 ID 포함)
     */
    public static ProductEntity updateFromDomain(Product product) {
        return ProductEntity.builder()
                .id(product.getProductId())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .category(product.getCategory())
                .subCategory(product.getSubCategory())
                .modelNumber(product.getModelNumber())
                .size(product.getSize())
                .color(product.getColor())
                .description(product.getDescription())
                .condition(product.getCondition().name())
                .retailPrice(product.getRetailPrice())
                .imageUrls(toJsonArray(product.getImageUrls()))
                .specifications(toJsonObject(product.getSpecifications()))
                .status(product.getStatus().name())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    // JSON 변환 헬퍼 메서드
    private static String toJsonArray(java.util.List<String> list) {
        // 실제 구현 시 ObjectMapper 사용
        return list != null ? list.toString() : null;
    }

    private static String toJsonObject(java.util.Map<String, String> map) {
        // 실제 구현 시 ObjectMapper 사용
        return map != null ? map.toString() : null;
    }

    private static java.util.List<String> parseImageUrls(String json) {
        // 실제 구현 시 ObjectMapper 사용
        return json != null ? new java.util.ArrayList<>() : null;
    }

    private static java.util.Map<String, String> parseSpecifications(String json) {
        // 실제 구현 시 ObjectMapper 사용
        return json != null ? new java.util.HashMap<>() : null;
    }
}

