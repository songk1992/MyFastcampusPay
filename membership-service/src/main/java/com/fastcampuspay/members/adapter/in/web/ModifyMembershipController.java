package com.fastcampuspay.members.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.members.application.port.in.ModifyMembershipCommand;
import com.fastcampuspay.members.application.port.in.ModifyMembershipUseCase;
import com.fastcampuspay.members.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping(path = "/membership/modify")
    Membership ModifyMembership(@RequestBody ModifyMembershipRequest request) {
        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();
        return modifyMembershipUseCase.modifyMembership(command);
    }


}
