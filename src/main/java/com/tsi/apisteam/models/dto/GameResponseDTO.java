package com.tsi.apisteam.models.dto;

import com.tsi.apisteam.models.entity.Game;

public class GameResponseDTO {
    private boolean success;

    private String message;

    private Game game;

    public GameResponseDTO(boolean success, Game game, String message) {
        this.success = success;
        this.game = game;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
