package com.fastcampuspay.members.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {
    @Getter
    private final String membershipId;
    @Getter
    private final String name;
    @Getter
    private final String email;
    @Getter
    private final String address;
    @Getter
    private final boolean isValid;
    @Getter
    private final boolean isCorp;

    public static Membership generateMember(
            MembershipId membershipId,
            MembershipName membershipName,
            MembershipEmail membershipEmail,
            MembershipAddress membershipAddress,
            MembershipIsValid membershipIsValid,
            MembershipIsCorp membershipIsCorp
    ) {
        return new Membership(
                membershipId.membershipId,
                membershipName.name,
                membershipEmail.email,
                membershipAddress.address,
                membershipIsValid.isValid,
                membershipIsCorp.isCorp
        );
    }

    @Value
    public static class MembershipId {
        String membershipId;

        public MembershipId(String value) {
            this.membershipId = value;
        }
    }

    @Value
    public static class MembershipName {
        String name;

        public MembershipName(String value) {
            this.name = value;
        }
    }

    @Value
    public static class MembershipEmail {
        String email;

        public MembershipEmail(String value) {
            this.email = value;
        }
    }

    @Value
    public static class MembershipAddress {
        String address;

        public MembershipAddress(String value) {
            this.address = value;
        }
    }

    @Value
    public static class MembershipIsValid {
        boolean isValid;

        public MembershipIsValid(boolean value) {
            this.isValid = value;
        }
    }

    @Value
    public static class MembershipIsCorp {
        boolean isCorp;

        public MembershipIsCorp(boolean value) {
            this.isCorp = value;
        }
    }
}
