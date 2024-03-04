package org.exhandl.homework3.data;

public enum Gender {
    MALE("m"),
    FEMALE("f");

    private final String genderSymbol;

    Gender(String genderSymbol) {
        this.genderSymbol = genderSymbol;
    }

    public String getGenderSymbol() {
        return genderSymbol;
    }

    public static Gender getGender(String genderSymbol) {
        for (Gender gender : values()) {
            if (gender.getGenderSymbol().equals(genderSymbol)) {
                return gender;
            }
        }
        return null;
    }

}
