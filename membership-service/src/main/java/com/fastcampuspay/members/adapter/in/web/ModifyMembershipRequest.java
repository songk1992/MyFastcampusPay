package com.fastcampuspay.members.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyMembershipRequest {
    private String membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isCorp;
}
