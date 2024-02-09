package com.fastcampuspay.members.application.port.in;

import com.fastcampuspay.members.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}
