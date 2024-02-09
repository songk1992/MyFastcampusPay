package com.fastcampuspay.members.application.port.in;

import com.fastcampuspay.members.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
