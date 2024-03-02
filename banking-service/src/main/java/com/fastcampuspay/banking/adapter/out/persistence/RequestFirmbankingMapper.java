package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.domain.RequestFirmbanking;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestFirmbankingMapper {
    public RequestFirmbanking mapToDomainEntity(RequestFirmbankingJpaEntity requestFirmbankingJpaEntity, UUID uuid) {
        return RequestFirmbanking.generateFirmbankingRequest(
                new RequestFirmbanking.FirmbankingRequestId(requestFirmbankingJpaEntity.getRequestFirmbankingId() + ""),
                new RequestFirmbanking.FromBankName(requestFirmbankingJpaEntity.getFromBankName()),
                new RequestFirmbanking.FromBankAccountNumber(requestFirmbankingJpaEntity.getFromBankAccountNumber()),
                new RequestFirmbanking.ToBankName(requestFirmbankingJpaEntity.getToBankName()),
                new RequestFirmbanking.ToBankAccountNumber(requestFirmbankingJpaEntity.getToBankAccountNumber()),
                new RequestFirmbanking.MoneyAmount(requestFirmbankingJpaEntity.getMoneyAmount()),
                new RequestFirmbanking.FirmbankingStatus(requestFirmbankingJpaEntity.getFirmbankingStatus()),
                uuid
        );
    }
}
