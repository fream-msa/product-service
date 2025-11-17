package com.fream_v2.product_service.domain.product.domain.exception;

import com.fream_v2.product_service.global.presentation.exception.ErrorCode;
import com.fream_v2.product_service.global.presentation.exception.GlobalException;

/**
 * 상품 도메인 예외
 */
public class ProductException extends GlobalException {

    public ProductException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ProductException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ProductException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public ProductException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    // ===== 자주 사용되는 예외 생성 정적 팩토리 메서드 =====

    // 조회 관련
    public static ProductException notFound() {
        return new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND);
    }

    public static ProductException notFound(Long productId) {
        return new ProductException(ProductErrorCode.PRODUCT_ID_NOT_FOUND,
                String.format("상품을 찾을 수 없습니다. ID: %d", productId));
    }

    public static ProductException notFoundByModel(String modelNumber) {
        return new ProductException(ProductErrorCode.PRODUCT_MODEL_NOT_FOUND,
                String.format("해당 모델의 상품을 찾을 수 없습니다: %s", modelNumber));
    }

    // 등록 관련
    public static ProductException alreadyExists(String modelNumber) {
        return new ProductException(ProductErrorCode.PRODUCT_ALREADY_EXISTS,
                String.format("이미 등록된 상품입니다. 모델번호: %s", modelNumber));
    }

    public static ProductException invalidProductName() {
        return new ProductException(ProductErrorCode.INVALID_PRODUCT_NAME);
    }

    public static ProductException invalidCategory(String category) {
        return new ProductException(ProductErrorCode.INVALID_CATEGORY,
                String.format("유효하지 않은 카테고리입니다: %s", category));
    }

    // 상태 관련
    public static ProductException notTradable(Long productId) {
        return new ProductException(ProductErrorCode.PRODUCT_NOT_TRADABLE,
                String.format("거래 불가능한 상품입니다. ID: %d", productId));
    }

    public static ProductException alreadySold(Long productId) {
        return new ProductException(ProductErrorCode.PRODUCT_ALREADY_SOLD,
                String.format("이미 판매된 상품입니다. ID: %d", productId));
    }

    public static ProductException suspended(Long productId) {
        return new ProductException(ProductErrorCode.PRODUCT_SUSPENDED,
                String.format("관리자에 의해 중지된 상품입니다. ID: %d", productId));
    }

    // 이미지 관련
    public static ProductException imageTooLarge(long size) {
        return new ProductException(ProductErrorCode.IMAGE_TOO_LARGE,
                String.format("이미지 크기가 너무 큽니다. 현재: %dMB, 최대: 10MB", size / 1024 / 1024));
    }

    public static ProductException invalidImageFormat(String format) {
        return new ProductException(ProductErrorCode.INVALID_IMAGE_FORMAT,
                String.format("지원하지 않는 이미지 형식입니다: %s", format));
    }

    public static ProductException imageCountExceeded(int count) {
        return new ProductException(ProductErrorCode.IMAGE_COUNT_EXCEEDED,
                String.format("이미지 개수 초과. 현재: %d개, 최대: 10개", count));
    }

    // 가격 관련
    public static ProductException priceTooLow(Long price) {
        return new ProductException(ProductErrorCode.PRICE_TOO_LOW,
                String.format("가격이 너무 낮습니다: %d원", price));
    }

    public static ProductException priceTooHigh(Long price) {
        return new ProductException(ProductErrorCode.PRICE_TOO_HIGH,
                String.format("가격이 너무 높습니다: %d원", price));
    }

    // 사이즈 관련
    public static ProductException invalidSize(String size) {
        return new ProductException(ProductErrorCode.INVALID_SIZE,
                String.format("유효하지 않은 사이즈입니다: %s", size));
    }

    public static ProductException sizeRequired() {
        return new ProductException(ProductErrorCode.SIZE_REQUIRED);
    }
}