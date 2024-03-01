package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {
    public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity RegisteredBankAccountJpaEntity) {
        return RegisteredBankAccount.generateRegisterBankAccount(
                new RegisteredBankAccount.RegisterBankAccountId(RegisteredBankAccountJpaEntity.getRegisterBankAccountId() + ""),
                new RegisteredBankAccount.MembershipId(RegisteredBankAccountJpaEntity.getMembershipId()),
                new RegisteredBankAccount.BankName(RegisteredBankAccountJpaEntity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(RegisteredBankAccountJpaEntity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(RegisteredBankAccountJpaEntity.isLinkedStatusIsValid())
        );
    }
}
