package com.fastcampuspay.banking.application.port.in;

import com.fastcampuspay.banking.domain.RequestFirmbanking;

public interface RequestFirmbankingUseCase {

    RequestFirmbanking requestFirmbanking(RequestFirmbankingCommand command);
}
