package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.fastcampuspay.banking.domain.RegisterBankAccount;

public interface RegisterBankAccountPort {
    RegisterBankAccountJpaEntity createRegisterBankAccount(
            RegisterBankAccount.RegisterBankAccountId registerBankAccountId,
            RegisterBankAccount.MembershipId membershipId,
            RegisterBankAccount.BankName bankName,
            RegisterBankAccount.BankAccountNumber bankAccountNumber,
            RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}