package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.adapter.out.persistence.RequestFirmbankingJpaEntity;
import com.fastcampuspay.banking.domain.RequestFirmbanking;

import java.util.UUID;

public interface RequestFirmbankingPort {
    RequestFirmbankingJpaEntity createRequestFirmbanking(
            RequestFirmbanking.FromBankName fromBankName,
            RequestFirmbanking.FromBankAccountNumber fromBankAccountNumber,
            RequestFirmbanking.ToBankName toBankName,
            RequestFirmbanking.ToBankAccountNumber toBankAccountNumber,
            RequestFirmbanking.MoneyAmount moneyAmount,
            RequestFirmbanking.FirmbankingStatus firmbankingStatus,
            UUID uuid
    );

    RequestFirmbankingJpaEntity modifyRequestFirmbanking(
            RequestFirmbankingJpaEntity entity
    );
}
