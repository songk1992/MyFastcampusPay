package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import com.fastcampuspay.banking.domain.RequestFirmbanking;
import com.fastcampuspay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestFirmbankingPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataRequestFirmbankingRepository requestFirmbankingRepository;

    @Override
    public RequestFirmbankingJpaEntity createRequestFirmbanking(
            RequestFirmbanking.FromBankName fromBankName,
            RequestFirmbanking.FromBankAccountNumber fromBankAccountNumber,
            RequestFirmbanking.ToBankName toBankName,
            RequestFirmbanking.ToBankAccountNumber toBankAccountNumber,
            RequestFirmbanking.MoneyAmount moneyAmount,
            RequestFirmbanking.FirmbankingStatus firmbankingStatus,
            UUID uuid
    ) {
        return requestFirmbankingRepository.save(
                new RequestFirmbankingJpaEntity(
                        null,
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(),
                        firmbankingStatus.getFirmbankingStatus(),
                        uuid
                )
        );
    }

    @Override
    public RequestFirmbankingJpaEntity modifyRequestFirmbanking(RequestFirmbankingJpaEntity entity) {
        return requestFirmbankingRepository.save(entity);
    }
}

