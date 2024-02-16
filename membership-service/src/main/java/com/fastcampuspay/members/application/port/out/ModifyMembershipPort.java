package com.fastcampuspay.members.application.port.out;

import com.fastcampuspay.members.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.members.domain.Membership;

public interface ModifyMembershipPort {
    MembershipJpaEntity modifyMembership(
            Membership.MembershipId membershipId,
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    );
}
