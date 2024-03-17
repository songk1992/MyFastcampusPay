package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import com.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.out.GetMembershipPort;
import com.fastcampuspay.banking.application.port.out.MembershipStatus;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final GetMembershipPort getMembershipPort;
    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // call membership svc 정상인지 확인
        // call external bank svc 정상인지 확인
        MembershipStatus membershipStatus = getMembershipPort.getMembership(command.getMembershipId());
        if (!membershipStatus.isValid()) {
            return null;
        }

        // 은행 계좌를 등록해야 하는 서비스
        // 1. 등록된 계좌인지 확인
        // Biz Logic -> External Sys
        // Port -> Adapter -> External System
        // Port
        // 실제 외부의 은행 계좌 정보를 GET
        command.getBankName();
        command.getBankAccountNumber();

        // 실제 외부의 은행계좌 정보를 Get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        // 2. 등록 가능한 계좌라면 등록. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록 가능하지 않은 계좌라면 에러 리턴
        if (accountIsValid) {
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.RegisterBankAccountId(command.getBankAccountNumber()),
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );
            return registeredBankAccountMapper.mapToDomainEntity(savedAccountInfo);
        }
        return null;
    }
}
