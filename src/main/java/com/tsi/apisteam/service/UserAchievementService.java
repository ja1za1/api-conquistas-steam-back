package com.tsi.apisteam.service;

import com.tsi.apisteam.models.dto.AmountUserAchievementResponseDTO;
import com.tsi.apisteam.models.dto.UserAchievementResponseDTO;
import com.tsi.apisteam.models.dto.AmountUserAchievementByCountryDTO;
import com.tsi.apisteam.models.entity.UserAchievement;
import com.tsi.apisteam.models.dto.UserAchievementInfoDTO;
import com.tsi.apisteam.repository.UserAchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAchievementService {

    @Autowired
    private UserAchievementRepository userAchievementRepository;

    @Autowired
    private AchievementsAmountByGameMapper achievementsAmountByGameMapper;

    @Autowired
    private final ValidationService validationService = new ValidationService();

    public ResponseEntity<UserAchievementResponseDTO> getUserAchievementsByCountry(String appid, String country) {
        if(validationService.isValidAppId(appid)){
            if(validationService.isValidCountry(country)){
                List<UserAchievement> userAchievements = userAchievementRepository.getUserAchievementsByCountry(appid, country.toUpperCase());
                if(userAchievements.size() > 0){
                    UserAchievementResponseDTO.AchievementsPercentage achievementsPercentage = calculateAchievementsPercentagesByGame(userAchievements, appid);


                    UserAchievementResponseDTO.AchievementsInfo achievementsInfo = new UserAchievementResponseDTO.AchievementsInfo();

                    achievementsInfo.setTotalAmount(userAchievements.size());
                    achievementsInfo.setAchievementsPercentage(achievementsPercentage);

                    UserAchievementResponseDTO response = new UserAchievementResponseDTO();
                    response.setSuccess(true);
                    response.setCountry(country.toUpperCase());
                    response.setMessage("OK");
                    response.setAchievementsInfo(achievementsInfo);

                    return ResponseEntity.ok(response);
                }
                UserAchievementResponseDTO response = new UserAchievementResponseDTO();
                response.setSuccess(false);
                response.setMessage("No achievement found for appid or country provided");
                response.setCountry(country.toUpperCase());
                response.setAchievementsInfo(null);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            else{
                UserAchievementResponseDTO response = new UserAchievementResponseDTO();
                response.setSuccess(false);
                response.setMessage("Invalid country code");
                response.setCountry(null);
                response.setAchievementsInfo(null);

                return ResponseEntity.badRequest().body(response);
            }
        }
        UserAchievementResponseDTO response = new UserAchievementResponseDTO();
        response.setSuccess(false);
        response.setMessage("Invalid appid");
        response.setCountry(country.toUpperCase());
        response.setAchievementsInfo(null);

        return ResponseEntity.badRequest().body(response);
    }

    public ResponseEntity<AmountUserAchievementResponseDTO> getTopTenCountriesByUserAchievementsAmount(String appid) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(validationService.isValidAppId(appid)){
            List<AmountUserAchievementByCountryDTO> amountUserAchievementByCountries =
                    userAchievementRepository.getTopTenCountriesByUserAchievementsAmount(appid);
            if(amountUserAchievementByCountries.size() > 0){
                AmountUserAchievementResponseDTO response = new AmountUserAchievementResponseDTO();
                response.setSuccess(true);
                response.setMessage("OK");
                response.setAmountUserAchievementsByCountry(amountUserAchievementByCountries);

                return ResponseEntity.ok(response);
            }

            AmountUserAchievementResponseDTO response = new AmountUserAchievementResponseDTO();
            response.setSuccess(false);
            response.setMessage("No achievement found for appid or country provided");
            response.setAmountUserAchievementsByCountry(null);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }

        AmountUserAchievementResponseDTO response = new AmountUserAchievementResponseDTO();
        response.setSuccess(false);
        response.setMessage("Invalid appid");
        response.setAmountUserAchievementsByCountry(null);

        return ResponseEntity.badRequest().body(response);
    }



    private UserAchievementResponseDTO.AchievementsPercentage calculateAchievementsPercentagesByGame(List<UserAchievement> userAchievements, String appid){

        UserAchievementResponseDTO.AchievementsPercentage achievementsPercentage = new UserAchievementResponseDTO.AchievementsPercentage();


        for(UserAchievement userAchievement : userAchievements){
            final int AMOUNT_ACHIEVEMENTS = userAchievement.getAchievements().size();
            final int GAME_AMOUNT_ACHIEVEMENTS = achievementsAmountByGameMapper.getAchievementsAmount(appid);
            final float PERCENTAGE_ACHIEVEMENTS = (float) AMOUNT_ACHIEVEMENTS / GAME_AMOUNT_ACHIEVEMENTS * 100;

            if(PERCENTAGE_ACHIEVEMENTS == 100){
                achievementsPercentage.setHundred(achievementsPercentage.getHundred()+1);
            } else if (PERCENTAGE_ACHIEVEMENTS >= 80) {
                achievementsPercentage.setGreaterThan80(achievementsPercentage.getGreaterThan80()+1);
            } else if (PERCENTAGE_ACHIEVEMENTS >= 50) {
                achievementsPercentage.setGreaterThan50(achievementsPercentage.getGreaterThan50()+1);
            } else if (PERCENTAGE_ACHIEVEMENTS > 20) {
                achievementsPercentage.setGreaterThan20(achievementsPercentage.getGreaterThan20()+1);
            } else {
                achievementsPercentage.setLessOrEqual20(achievementsPercentage.getLessOrEqual20()+1);
            }
        }
        return achievementsPercentage;
    }

    private List<List<UserAchievementInfoDTO>> getAllUsersAchievementsInfo(List<UserAchievement> achievements){
        List<List<UserAchievementInfoDTO>> userAchievements = new ArrayList<>();
        for(UserAchievement userAchievement : achievements){
            userAchievements.add(userAchievement.getAchievements());
        }
        return userAchievements;
    }
}
