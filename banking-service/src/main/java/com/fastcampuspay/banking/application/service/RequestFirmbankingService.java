package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.fastcampuspay.banking.adapter.out.external.bank.FirmbankingResult;
import com.fastcampuspay.banking.adapter.out.persistence.RequestFirmbankingJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RequestFirmbankingMapper;
import com.fastcampuspay.banking.application.port.in.RequestFirmbankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmbankingUseCase;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.fastcampuspay.banking.application.port.out.RequestFirmbankingPort;
import com.fastcampuspay.banking.domain.RequestFirmbanking;
import com.fastcampuspay.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final RequestFirmbankingMapper mapper;
    private final RequestFirmbankingPort requestFirmbankingPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    @Override
    public RequestFirmbanking requestFirmbanking(RequestFirmbankingCommand command) {
        UUID uuid = UUID.randomUUID();
        // Business Logic

        // a -> b 계좌

        // 1. 요청에 대해 정보를 먼저 write . "요청 상태로
        RequestFirmbankingJpaEntity requestEntity = requestFirmbankingPort.createRequestFirmbanking(
                new RequestFirmbanking.FromBankName(command.getFromBankName()),
                new RequestFirmbanking.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new RequestFirmbanking.ToBankName(command.getToBankName()),
                new RequestFirmbanking.ToBankAccountNumber(command.getToBankAccountNumber()),
                new RequestFirmbanking.MoneyAmount(command.getMoneyAmount()),
                new RequestFirmbanking.FirmbankingStatus(0),
                uuid
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(
                new ExternalFirmbankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber()
                )
        );

        // 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 update
        if (result.getResultCode() == 0) {
            // 성공
            requestEntity.setFirmbankingStatus(1);
        } else {
            // 실패
            requestEntity.setFirmbankingStatus(2);
        }

        // 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyRequestFirmbanking(requestEntity), uuid);
    }
}
