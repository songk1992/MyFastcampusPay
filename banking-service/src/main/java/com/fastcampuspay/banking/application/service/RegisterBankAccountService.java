package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RegisterBankAccountMapper;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.domain.RegisterBankAccount;
import com.fastcampuspay.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisterBankAccountMapper registerBankAccountMapper;

    @Override
    public RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야 하는 서비스
        // 1. 등록된 계좌인지 확인

        // 2. 등록 가능한 계좌라면 등록

        // 2-1. 등록 가능하지 않은 계좌라면 에러 리턴


        RegisterBankAccountJpaEntity jpaEntity = registerBankAccountPort.createRegisterBankAccount(
                new RegisterBankAccount.RegisterBankAccountId(command.getBankAccountNumber()),
                new RegisterBankAccount.MembershipId(command.getMembershipId()),
                new RegisterBankAccount.BankName(command.getBankName()),
                new RegisterBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                new RegisterBankAccount.LinkedStatusIsValid(command.isValid())
        );

        return registerBankAccountMapper.mapToDomainEntity(jpaEntity);
    }
}
