package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.GameTerbeli;

import java.util.List;

public interface GameTerbeliService {
    public GameTerbeli inputGameTerbeli(GameTerbeli gameTerbeli);
    public List<GameTerbeli> getGameTerbeliByUserId(String idPengguna);
    public GameTerbeli gameTerbeliReview(String idPermainan, String idPengguna);
    public GameTerbeli gameTerbeliNoReview(String idPermainan, String idPengguna);
}
