package com.fream_v2.product_service.domain.product.domain.exception;

import com.fream_v2.product_service.global.presentation.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 상품 도메인 에러 코드
 */
@Getter
@RequiredArgsConstructor
public enum ProductErrorCode implements ErrorCode {

    // ===== 상품 조회 관련 (PROD_001 ~ PROD_099) =====
    PRODUCT_NOT_FOUND("PROD_001", "상품을 찾을 수 없습니다.", 404),
    PRODUCT_ID_NOT_FOUND("PROD_002", "해당 ID의 상품을 찾을 수 없습니다.", 404),
    PRODUCT_MODEL_NOT_FOUND("PROD_003", "해당 모델의 상품을 찾을 수 없습니다.", 404),
    PRODUCT_DATA_CORRUPTED("PROD_004", "상품 데이터가 손상되었습니다.", 500),
    CATEGORY_NOT_FOUND("PROD_005", "카테고리를 찾을 수 없습니다.", 404),
    BRAND_NOT_FOUND("PROD_006", "브랜드를 찾을 수 없습니다.", 404),

    // ===== 상품 등록 관련 (PROD_100 ~ PROD_199) =====
    PRODUCT_ALREADY_EXISTS("PROD_100", "이미 등록된 상품입니다.", 409),
    INVALID_PRODUCT_NAME("PROD_101", "상품명이 유효하지 않습니다.", 400),
    INVALID_BRAND("PROD_102", "브랜드 정보가 유효하지 않습니다.", 400),
    INVALID_CATEGORY("PROD_103", "카테고리가 유효하지 않습니다.", 400),
    INVALID_MODEL_NUMBER("PROD_104", "모델 번호가 유효하지 않습니다.", 400),
    INVALID_PRODUCT_CONDITION("PROD_105", "상품 상태가 유효하지 않습니다.", 400),
    INVALID_RETAIL_PRICE("PROD_106", "정가가 유효하지 않습니다.", 400),
    PRODUCT_REGISTRATION_FAILED("PROD_107", "상품 등록에 실패했습니다.", 500),
    DUPLICATE_MODEL_NUMBER("PROD_108", "중복된 모델 번호입니다.", 409),
    REQUIRED_SPECIFICATION_MISSING("PROD_109", "필수 사양 정보가 누락되었습니다.", 400),

    // ===== 상품 수정 관련 (PROD_200 ~ PROD_299) =====
    PRODUCT_UPDATE_FAILED("PROD_200", "상품 정보 수정에 실패했습니다.", 500),
    CANNOT_UPDATE_MODEL_NUMBER("PROD_201", "모델 번호는 수정할 수 없습니다.", 400),
    CANNOT_UPDATE_BRAND("PROD_202", "브랜드는 수정할 수 없습니다.", 400),
    PRODUCT_IN_USE("PROD_203", "거래 중인 상품은 수정할 수 없습니다.", 400),
    INVALID_PRODUCT_STATUS("PROD_204", "유효하지 않은 상품 상태입니다.", 400),

    // ===== 상품 이미지 관련 (PROD_300 ~ PROD_399) =====
    IMAGE_UPLOAD_FAILED("PROD_300", "이미지 업로드에 실패했습니다.", 500),
    IMAGE_TOO_LARGE("PROD_301", "이미지 크기는 10MB 이하여야 합니다.", 400),
    INVALID_IMAGE_FORMAT("PROD_302", "지원하지 않는 이미지 형식입니다.", 400),
    IMAGE_COUNT_EXCEEDED("PROD_303", "이미지는 최대 10장까지 등록 가능합니다.", 400),
    IMAGE_NOT_FOUND("PROD_304", "이미지를 찾을 수 없습니다.", 404),
    MAIN_IMAGE_REQUIRED("PROD_305", "대표 이미지는 필수입니다.", 400),

    // ===== 상품 상태 관련 (PROD_400 ~ PROD_499) =====
    PRODUCT_NOT_TRADABLE("PROD_400", "거래 불가능한 상품입니다.", 400),
    PRODUCT_ALREADY_SOLD("PROD_401", "이미 판매된 상품입니다.", 400),
    PRODUCT_SUSPENDED("PROD_402", "관리자에 의해 중지된 상품입니다.", 403),
    PRODUCT_DELETED("PROD_403", "삭제된 상품입니다.", 404),
    PRODUCT_INACTIVE("PROD_404", "비활성화된 상품입니다.", 400),

    // ===== 카테고리 관련 (PROD_500 ~ PROD_599) =====
    INVALID_CATEGORY_HIERARCHY("PROD_500", "카테고리 계층 구조가 올바르지 않습니다.", 400),
    CATEGORY_MISMATCH("PROD_501", "상품과 카테고리가 일치하지 않습니다.", 400),
    SUBCATEGORY_REQUIRED("PROD_502", "하위 카테고리 선택이 필요합니다.", 400),
    CATEGORY_DEPRECATED("PROD_503", "더 이상 사용되지 않는 카테고리입니다.", 400),

    // ===== 사이즈/컬러 관련 (PROD_600 ~ PROD_699) =====
    INVALID_SIZE("PROD_600", "유효하지 않은 사이즈입니다.", 400),
    INVALID_COLOR("PROD_601", "유효하지 않은 색상입니다.", 400),
    SIZE_NOT_AVAILABLE("PROD_602", "해당 사이즈는 사용할 수 없습니다.", 400),
    SIZE_REQUIRED("PROD_603", "사이즈 정보는 필수입니다.", 400),

    // ===== 가격 관련 (PROD_700 ~ PROD_799) =====
    PRICE_TOO_LOW("PROD_700", "가격이 너무 낮습니다.", 400),
    PRICE_TOO_HIGH("PROD_701", "가격이 너무 높습니다.", 400),
    INVALID_PRICE_RANGE("PROD_702", "유효하지 않은 가격 범위입니다.", 400),
    PRICE_CALCULATION_ERROR("PROD_703", "가격 계산 중 오류가 발생했습니다.", 500),

    // ===== 검증 관련 (PROD_800 ~ PROD_899) =====
    PRODUCT_DATA_INVALID("PROD_800", "상품 데이터가 유효하지 않습니다.", 400),
    REQUIRED_FIELD_MISSING("PROD_801", "필수 입력 항목이 누락되었습니다.", 400),
    INVALID_SPECIFICATION("PROD_802", "사양 정보가 올바르지 않습니다.", 400),
    DESCRIPTION_TOO_SHORT("PROD_803", "상품 설명이 너무 짧습니다.", 400),
    DESCRIPTION_TOO_LONG("PROD_804", "상품 설명이 너무 깁니다.", 400);

    private final String code;
    private final String message;
    private final int status;
}