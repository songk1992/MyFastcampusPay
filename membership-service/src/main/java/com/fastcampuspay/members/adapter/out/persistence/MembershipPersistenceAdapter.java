package com.fastcampuspay.members.adapter.out.persistence;

import com.fastcampuspay.members.application.port.out.FindMembershipPort;
import com.fastcampuspay.members.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.members.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.members.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                new MembershipJpaEntity(membershipName.getName(),
                        membershipEmail.getEmail(),
                        membershipAddress.getAddress(),
                        membershipIsValid.isValid(),
                        membershipIsCorp.isCorp())
        );
    }


    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        MembershipJpaEntity entity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
        entity.setName(membershipName.getName());
        entity.setAddress(membershipAddress.getAddress());
        entity.setEmail(membershipEmail.getEmail());
        entity.setCorp(membershipIsCorp.isCorp());
        entity.setValid(membershipIsValid.isValid());
        return membershipRepository.save(entity);
    }
}
