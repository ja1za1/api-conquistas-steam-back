package com.tsi.apisteam.repository;

import com.tsi.apisteam.models.dto.AmountUserAchievementByCountryDTO;
import com.tsi.apisteam.models.entity.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {
    @Query("SELECT ua FROM UserAchievement ua " +
            "WHERE ua.appId = :appid " +
            "AND CAST(ua.achievements AS text) NOT LIKE '{\"erro%\"}' " +
            "AND CAST(ua.achievements AS text) != CAST('{}' AS text) " +
            "AND ua.country = :country")
    List<UserAchievement> getUserAchievementsByCountry(@Param("appid") String appid,
                                                       @Param("country") String country);

    @Query("SELECT new com.tsi.apisteam.models.dto.AmountUserAchievementByCountryDTO(country, COUNT(*) AS " +
            "userAchievementAmount) FROM UserAchievement ua " +
            "WHERE ua.appId = :appid " +
            "AND CAST(ua.achievements AS text) NOT LIKE '{\"erro%\"}' " +
            "AND CAST(ua.achievements AS text) != CAST('{}' AS text) " +
            "GROUP BY country " +
            "ORDER BY userAchievementAmount DESC " +
            "LIMIT 10")
    List<AmountUserAchievementByCountryDTO> getTopTenCountriesByUserAchievementsAmount(@Param("appid") String appid);
}
