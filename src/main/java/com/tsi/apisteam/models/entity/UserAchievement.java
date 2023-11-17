package com.tsi.apisteam.models.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsi.apisteam.models.dto.UserAchievementInfoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.IOException;
import java.util.List;

@Entity
@Table(name = "conquistas")
public class UserAchievement {
    @Id
    private long id;

    @Column(name = "steam_id")
    private String steamId;

    @Column(name = "appid")
    private String appId;

    @Column(name = "pais")
    private String country;

    @Column(name = "conquistas_json", columnDefinition = "json")
    private String achievements;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<UserAchievementInfoDTO> getAchievements() {
        if(achievements != null){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try{
                return objectMapper.readValue(achievements, new TypeReference<>() {
                });
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
}
