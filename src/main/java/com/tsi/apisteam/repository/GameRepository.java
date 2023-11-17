package com.tsi.apisteam.repository;

import com.tsi.apisteam.models.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByAppid(String appid);
}
