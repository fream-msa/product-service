package com.fream_v2.product_service.domain.product.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 상품 상태 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum ProductCondition {
    NEW("새 상품", "미개봉 새 상품", 1.0),
    LIKE_NEW("거의 새 것", "사용감이 거의 없는 상품", 0.95),
    GOOD("좋음", "사용감이 적은 상품", 0.85),
    FAIR("보통", "일반적인 사용감이 있는 상품", 0.75),
    POOR("나쁨", "사용감이 많은 상품", 0.65);

    private final String name;
    private final String description;
    private final Double priceRate; // 정가 대비 예상 가격 비율

    /**
     * 예상 가격 계산
     */
    public Long calculateExpectedPrice(Long retailPrice) {
        return Math.round(retailPrice * this.priceRate);
    }
}
