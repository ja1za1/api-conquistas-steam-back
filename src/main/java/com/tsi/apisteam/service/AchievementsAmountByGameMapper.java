package com.tsi.apisteam.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AchievementsAmountByGameMapper {
    private static final Map<String, Integer> MAPPER = new HashMap<>();

    static {
        MAPPER.put("49520", 75);
        MAPPER.put("12210", 55);
        MAPPER.put("1245620", 42);
        MAPPER.put("105600", 115);
        MAPPER.put("377160", 84);
        MAPPER.put("1174180", 51);
        MAPPER.put("440", 520);
        MAPPER.put("578080", 37);
        MAPPER.put("374320", 43);
        MAPPER.put("236430", 38);
        MAPPER.put("1091500", 57);
        MAPPER.put("271590", 77);
        MAPPER.put("814380", 34);
        MAPPER.put("550", 101);
        MAPPER.put("1593500", 37);
    }

    public int getAchievementsAmount(String appid) {
        return MAPPER.getOrDefault(appid, 0);
    }
}
