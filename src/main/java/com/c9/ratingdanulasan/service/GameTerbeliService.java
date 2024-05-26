package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.GameTerbeli;

import java.util.List;

public interface GameTerbeliService {
    public GameTerbeli inputGameTerbeli(GameTerbeli gameTerbeli);
    public List<GameTerbeli> getGameTerbeliByUserId(String userId);
    public GameTerbeli gameTerbeliReview(String gameId, String userId);
    public GameTerbeli gameTerbeliNoReview(String gameId, String userId);
}
