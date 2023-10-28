package com.api.datalytics.domain.enums;

public enum Profile {

    ADMIN(0, "ROLE_ADMIN"),
    CUSTOMER(1, "ROLE_CUSTOMER"),
    CONSULTANT(2, "ROLE_CONSULTANT");

    private final Integer code;
    private final String desc;

    Profile(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Profile toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (Profile profile : Profile.values()) {
            if (code.equals(profile.getCode())) {
                return profile;
            }
        }

        throw new IllegalArgumentException("Perfil inválido");
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
