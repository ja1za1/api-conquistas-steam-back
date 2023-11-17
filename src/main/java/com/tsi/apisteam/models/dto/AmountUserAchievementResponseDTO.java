package com.tsi.apisteam.models.dto;

import java.util.List;

public class AmountUserAchievementResponseDTO {

    private boolean success;

    private String message;

    private List<AmountUserAchievementByCountryDTO> amountUserAchievementsByCountry;

    public AmountUserAchievementResponseDTO(boolean success, String message, List<AmountUserAchievementByCountryDTO> amountUserAchievementsByCountry) {
        this.success = success;
        this.message = message;
        this.amountUserAchievementsByCountry = amountUserAchievementsByCountry;
    }

    public AmountUserAchievementResponseDTO() {}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AmountUserAchievementByCountryDTO> getAmountUserAchievementsByCountry() {
        return amountUserAchievementsByCountry;
    }

    public void setAmountUserAchievementsByCountry(List<AmountUserAchievementByCountryDTO> amountUserAchievementsByCountry) {
        this.amountUserAchievementsByCountry = amountUserAchievementsByCountry;
    }
}
