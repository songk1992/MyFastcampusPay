package com.fastcampuspay.members.application.port.out;

import com.fastcampuspay.members.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.members.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}
