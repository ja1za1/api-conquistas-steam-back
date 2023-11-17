package com.tsi.apisteam.models.dto;

public class UserAchievementInfoDTO {
    private String name;

    private boolean achieved;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
}
