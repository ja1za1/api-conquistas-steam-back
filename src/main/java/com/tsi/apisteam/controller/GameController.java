package com.tsi.apisteam.controller;


import com.tsi.apisteam.models.dto.GameResponseDTO;
import com.tsi.apisteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api/info")
public class GameController {
    @Autowired
    private final GameService gameService = new GameService();

    @ResponseBody
    @GetMapping("/{appid}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<GameResponseDTO> getGame(@PathVariable("appid")String appid){
        return gameService.getGame(appid);
    }

}
