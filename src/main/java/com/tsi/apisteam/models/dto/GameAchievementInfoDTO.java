package com.tsi.apisteam.models.dto;


public class GameAchievementInfoDTO {
    private String name;
    private String displayName;

    private boolean hidden;
    private String description;
    private String icon;
    private String iconGray;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconGray() {
        return iconGray;
    }

    public void setIconGray(String iconGray) {
        this.iconGray = iconGray;
    }
}
