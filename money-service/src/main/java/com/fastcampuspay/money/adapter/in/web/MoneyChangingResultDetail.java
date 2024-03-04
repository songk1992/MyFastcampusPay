package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.money.domain.MoneyChangingResultStatus;
import com.fastcampuspay.money.domain.MoneyChangingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {
    private String moneyChangingRequestId;

    // 증액, 감액
    private MoneyChangingType moneyChangingType;
    private MoneyChangingResultStatus moneyChangingResultStatus;
    private int amount;

}