package com.fastcampuspay.members.application.service;

import com.fastcampuspay.members.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.members.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.members.application.port.in.ModifyMembershipCommand;
import com.fastcampuspay.members.application.port.in.ModifyMembershipUseCase;
import com.fastcampuspay.members.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.members.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);


    }
}