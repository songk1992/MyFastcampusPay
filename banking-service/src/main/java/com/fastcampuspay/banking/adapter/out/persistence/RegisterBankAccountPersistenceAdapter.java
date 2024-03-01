package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.domain.RegisterBankAccount;
import com.fastcampuspay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisterBankAccountRepository RegisterBankAccountRepository;

    @Override
    public RegisterBankAccountJpaEntity createRegisterBankAccount(RegisterBankAccount.RegisterBankAccountId registerBankAccountId, RegisterBankAccount.MembershipId membershipId, RegisterBankAccount.BankName bankName, RegisterBankAccount.BankAccountNumber bankAccountNumber, RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return RegisterBankAccountRepository.save(
                new RegisterBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid())
        );

    }


}
