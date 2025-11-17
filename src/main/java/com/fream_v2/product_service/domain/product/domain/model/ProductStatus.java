package com.fream_v2.product_service.domain.product.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 상품 등록 상태 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum ProductStatus {
    ACTIVE("활성", "거래 가능한 상태"),
    INACTIVE("비활성", "거래 중지 상태"),
    DELETED("삭제", "삭제된 상태"),
    SUSPENDED("중지", "관리자에 의해 중지된 상태");

    private final String name;
    private final String description;

    public boolean isTradable() {
        return this == ACTIVE;
    }
}
