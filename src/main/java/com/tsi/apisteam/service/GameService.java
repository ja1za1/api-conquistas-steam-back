package com.tsi.apisteam.service;

import com.tsi.apisteam.models.dto.GameResponseDTO;
import com.tsi.apisteam.models.entity.Game;
import com.tsi.apisteam.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private final ValidationService validationService = new ValidationService();

    public ResponseEntity<GameResponseDTO> getGame(String appid) {
        if(validationService.isValidAppId(appid)){
            Game game = gameRepository.findByAppid(appid);
            return (game != null) ? ResponseEntity.ok(new GameResponseDTO(true, game, "OK")) :
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GameResponseDTO(false, null, "Game not found"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GameResponseDTO(false, null, "Invalid appid"));
    }

}
