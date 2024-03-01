package com.fastcampuspay.banking.application.port.in;

import com.fastcampuspay.banking.domain.RegisterBankAccount;

public interface RegisterBankAccountUseCase {

    RegisterBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
