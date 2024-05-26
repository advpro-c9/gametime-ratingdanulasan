package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.GameTerbeli;
import com.c9.ratingdanulasan.repository.GameTerbeliRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTerbeliServiceImpl implements GameTerbeliService {

    private final GameTerbeliRepository gameTerbeliRepository;

    private GameTerbeliServiceImpl(GameTerbeliRepository gameTerbeliRepository) {
        this.gameTerbeliRepository = gameTerbeliRepository;
    }

    public GameTerbeli inputGameTerbeli(GameTerbeli gameTerbeli){
        return gameTerbeliRepository.save(gameTerbeli);
    }

    public List<GameTerbeli> getGameTerbeliByUserId(String idPengguna){
        return gameTerbeliRepository.findAllByIdPengguna(idPengguna);
    }

    public GameTerbeli gameTerbeliReview(String idPermainan, String idPengguna){
        GameTerbeli findGameTerbeli = gameTerbeliRepository.findByGameIdAndUserId(idPermainan, idPengguna);
        findGameTerbeli.setReview(true);
        return gameTerbeliRepository.save(findGameTerbeli);
    }

    public GameTerbeli gameTerbeliNoReview(String idPermainan, String idPengguna){
        GameTerbeli findGameTerbeli = gameTerbeliRepository.findByGameIdAndUserId(idPermainan, idPengguna);
        findGameTerbeli.setReview(false);
        return gameTerbeliRepository.save(findGameTerbeli);
    }
}
