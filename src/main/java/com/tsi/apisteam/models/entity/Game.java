package com.tsi.apisteam.models.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsi.apisteam.models.dto.GameAchievementInfoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.IOException;
import java.util.List;
@Entity
@Table(name = "jogo")
public class Game {
    @Id
    private Integer id;
    @Column(name = "nome")
    private String name;

    @Column(name = "appid")
    private String appid;

    @Column(name = "descricao")
    private String description;

    @Column(name = "qtd_conquistas")
    private Integer achievementsAmount;

    @Column(name = "conquistas", columnDefinition = "json")
    private String achievements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAchievementsAmount() {
        return achievementsAmount;
    }

    public void setAchievementsAmount(Integer achievementsAmount) {
        this.achievementsAmount = achievementsAmount;
    }

    public List<GameAchievementInfoDTO> getAchievements() {
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
