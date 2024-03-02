package com.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestFirmbanking {
    @Getter
    private final String firmbankingRequestId;
    @Getter
    private final String fromBankName;
    @Getter
    private final String fromBankAccountNumber;
    @Getter
    private final String toBankName;
    @Getter
    private final String toBankAccountNumber;
    @Getter
    private final int moneyAmount;
    @Getter
    private final int firmbankingStatus; // 0: 요청 1: 완료 2: 실패
    @Getter
    private final UUID uuid;

    public static RequestFirmbanking generateFirmbankingRequest(
            RequestFirmbanking.FirmbankingRequestId firmbankingRequestId,
            RequestFirmbanking.FromBankName fromBankName,
            RequestFirmbanking.FromBankAccountNumber fromBankAccountNumber,
            RequestFirmbanking.ToBankName toBankName,
            RequestFirmbanking.ToBankAccountNumber toBankAccountNumber,
            RequestFirmbanking.MoneyAmount moneyAmount,
            RequestFirmbanking.FirmbankingStatus firmbankingStatus,
            UUID uuid
    ) {
        return new RequestFirmbanking(
                firmbankingRequestId.firmbankingRequestId,
                fromBankName.fromBankName,
                fromBankAccountNumber.fromBankAccountNumber,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                moneyAmount.moneyAmount,
                firmbankingStatus.firmbankingStatus,
                uuid
        );
    }

    @Value
    public static class FirmbankingRequestId {
        String firmbankingRequestId;

        public FirmbankingRequestId(String value) {
            this.firmbankingRequestId = value;
        }
    }

    @Value
    public static class FromBankName {
        String fromBankName;

        public FromBankName(String value) {
            this.fromBankName = value;
        }
    }

    @Value
    public static class FromBankAccountNumber {
        String fromBankAccountNumber;

        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber = value;
        }
    }

    @Value
    public static class ToBankName {
        String toBankName;

        public ToBankName(String value) {
            this.toBankName = value;
        }
    }

    @Value
    public static class ToBankAccountNumber {
        String toBankAccountNumber;

        public ToBankAccountNumber(String value) {
            this.toBankAccountNumber = value;
        }
    }

    @Value
    public static class MoneyAmount {
        int moneyAmount;

        public MoneyAmount(int value) {
            this.moneyAmount = value;
        }
    }

    @Value
    public static class FirmbankingStatus {
        int firmbankingStatus;

        public FirmbankingStatus(int value) {
            this.firmbankingStatus = value;
        }
    }
}
