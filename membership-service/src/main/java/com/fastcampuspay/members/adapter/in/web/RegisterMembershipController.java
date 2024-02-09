package com.fastcampuspay.members.adapter.in.web;

import com.fastcampuspay.members.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.members.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.members.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path = "/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest rquest) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(rquest.getName())
                .address(rquest.getAddress())
                .email(rquest.getEmail())
                .isValid(true)
                .isCorp(rquest.isCorp())
                .build();
        return registerMembershipUseCase.registerMembership(command);
    }


}
