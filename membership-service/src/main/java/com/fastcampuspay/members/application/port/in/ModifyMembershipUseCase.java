package com.fastcampuspay.members.application.port.in;

import com.fastcampuspay.members.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);
}
