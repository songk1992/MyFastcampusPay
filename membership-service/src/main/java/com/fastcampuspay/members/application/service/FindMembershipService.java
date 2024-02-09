package com.fastcampuspay.members.application.service;

import com.fastcampuspay.members.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.members.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.members.application.port.in.FindMembershipCommand;
import com.fastcampuspay.members.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.members.application.port.out.FindMembershipPort;
import com.fastcampuspay.members.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {

        MembershipJpaEntity jpaEntity = findMembershipPort.findMembership(
                new Membership.MembershipId(command.getMembershipId())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
