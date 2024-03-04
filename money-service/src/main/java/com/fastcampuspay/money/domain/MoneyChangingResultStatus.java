package com.fastcampuspay.money.domain;

// 0: 성공, 실패, 실패 - 잔액 부족, 실패 - 멤버십 없음, 실패 - 머니 변액 요청 없음
public enum MoneyChangingResultStatus {
    SUCCESS, // 성공
    FAILURE, // 실패
    INSUFFICIENT_BALANCE, // 실패 - 잔액 부족
    NO_MEMBERSHIP, // 실패 - 멤버십 없음
    NO_MONEY_CHANGE_REQUEST // 실패 - 머니 변액 요청 없음
}
