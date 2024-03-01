package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.domain.RegisterBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisterBankAccountMapper {
    public RegisterBankAccount mapToDomainEntity(RegisterBankAccountJpaEntity RegisterBankAccountJpaEntity) {
        return RegisterBankAccount.generateRegisterBankAccount(
                new RegisterBankAccount.RegisterBankAccountId(RegisterBankAccountJpaEntity.getRegisterBankAccountId() + ""),
                new RegisterBankAccount.MembershipId(RegisterBankAccountJpaEntity.getMembershipId()),
                new RegisterBankAccount.BankName(RegisterBankAccountJpaEntity.getBankName()),
                new RegisterBankAccount.BankAccountNumber(RegisterBankAccountJpaEntity.getBankAccountNumber()),
                new RegisterBankAccount.LinkedStatusIsValid(RegisterBankAccountJpaEntity.isLinkedStatusIsValid())
        );
    }
}
