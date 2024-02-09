package com.fastcampuspay.members.application.service;

import com.fastcampuspay.members.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.members.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.members.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.members.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.members.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.members.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
