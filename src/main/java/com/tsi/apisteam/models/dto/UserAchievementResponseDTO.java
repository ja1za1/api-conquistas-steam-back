package com.tsi.apisteam.models.dto;

public class UserAchievementResponseDTO {
    private boolean success;

    private String message;

    private String country;

    private AchievementsInfo achievementsInfo;

    public UserAchievementResponseDTO() {}

    public UserAchievementResponseDTO(boolean success, String message, String country, AchievementsInfo achievementsInfo) {
        this.success = success;
        this.message = message;
        this.country = country;
        this.achievementsInfo = achievementsInfo;
    }

    public UserAchievementResponseDTO(boolean success, String message, AchievementsInfo achievementsInfo) {
        this.success = success;
        this.message = message;
        this.achievementsInfo = achievementsInfo;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AchievementsInfo getAchievementsInfo() {
        return achievementsInfo;
    }

    public void setAchievementsInfo(AchievementsInfo achievements) {
        this.achievementsInfo = achievements;
    }

    public static class AchievementsInfo{
        private Integer totalAmount;

        private AchievementsPercentage achievementsPercentage;

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public AchievementsPercentage getAchievementsPercentage() {
            return achievementsPercentage;
        }

        public void setAchievementsPercentage(AchievementsPercentage achievementsPercentage) {
            this.achievementsPercentage = achievementsPercentage;
        }
    }

    public static class AchievementsPercentage {
        private Integer lessOrEqual20;

        private Integer greaterThan20;

        private Integer greaterThan50;

        private Integer greaterThan80;

        private Integer hundred;

        public AchievementsPercentage(){
            this.lessOrEqual20 = 0;
            this.greaterThan20 = 0;
            this.greaterThan50 = 0;
            this.greaterThan80 = 0;
            this.hundred = 0;
        }

        public Integer getLessOrEqual20() {
            return lessOrEqual20;
        }

        public void setLessOrEqual20(Integer lessOrEqual20) {
            this.lessOrEqual20 = lessOrEqual20;
        }

        public Integer getGreaterThan20() {
            return greaterThan20;
        }

        public void setGreaterThan20(Integer greaterThan20) {
            this.greaterThan20 = greaterThan20;
        }

        public Integer getGreaterThan50() {
            return greaterThan50;
        }

        public void setGreaterThan50(Integer greaterThan50) {
            this.greaterThan50 = greaterThan50;
        }

        public Integer getGreaterThan80() {
            return greaterThan80;
        }

        public void setGreaterThan80(Integer greaterThan80) {
            this.greaterThan80 = greaterThan80;
        }

        public Integer getHundred() {
            return hundred;
        }

        public void setHundred(Integer hundred) {
            this.hundred = hundred;
        }
    }
}




