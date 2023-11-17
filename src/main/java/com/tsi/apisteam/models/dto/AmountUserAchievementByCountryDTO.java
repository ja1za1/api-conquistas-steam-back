package com.tsi.apisteam.models.dto;

public class AmountUserAchievementByCountryDTO {

    private String country;

    private Long userAchievementAmount;

    public AmountUserAchievementByCountryDTO(String country, Long userAchievementAmount) {
        this.country = country;
        this.userAchievementAmount = userAchievementAmount;
    }

    public AmountUserAchievementByCountryDTO() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getUserAchievementAmount() {
        return userAchievementAmount;
    }

    public void setUserAchievementAmount(Long userAchievementAmount) {
        this.userAchievementAmount = userAchievementAmount;
    }
}
