package com.tsi.apisteam.controller;

import com.tsi.apisteam.models.dto.AmountUserAchievementResponseDTO;
import com.tsi.apisteam.models.dto.UserAchievementResponseDTO;
import com.tsi.apisteam.service.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping(value = "/api/achievements")
public class UserAchievementController {
    @Autowired
    private final UserAchievementService userAchievementService = new UserAchievementService();

    @ResponseBody
    @GetMapping("/{appid}/{country}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserAchievementResponseDTO> getUserAchievementsByCountryAndGame(@PathVariable("appid") String appid,@PathVariable("country") String country) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return userAchievementService.getUserAchievementsByCountry(appid, country);
    }

    @ResponseBody
    @GetMapping("/{appid}/top10countries")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AmountUserAchievementResponseDTO> getTopTenCountriesByUserAchievementsAmount(@PathVariable("appid") String appid) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return userAchievementService.getTopTenCountriesByUserAchievementsAmount(appid);
    }


}
