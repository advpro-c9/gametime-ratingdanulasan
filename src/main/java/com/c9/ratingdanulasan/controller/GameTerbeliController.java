package com.c9.ratingdanulasan.controller;

import com.c9.ratingdanulasan.model.GameTerbeli;
import com.c9.ratingdanulasan.service.GameTerbeliService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game-terbeli")
public class GameTerbeliController {

    private final GameTerbeliService service;

    private GameTerbeliController(GameTerbeliService service) {
        this.service = service;
    }

    public GameTerbeli inputGameTerbeli(@RequestBody Map<String, Object> data) {
        GameTerbeli gameTerbeli = new GameTerbeli(
                data.get("idPermainan").toString(),
                data.get("idPengguna").toString()
        );
        return service.inputGameTerbeli(gameTerbeli);
    }

    @GetMapping("/pengguna/{idPengguna}")
    public ResponseEntity<List<GameTerbeli>> getGameTerbeliPengguna(@PathVariable String idPengguna){
        List<GameTerbeli> gameTerbeliList = service.getGameTerbeliByUserId(idPengguna);
        return ResponseEntity.ok(gameTerbeliList);
    }

    @PatchMapping("/sudah-ditinjau/pengguna/{idPengguna}")
    public GameTerbeli gameTerbeliDitinjau(@PathVariable String idPengguna, @RequestBody Map<String, Object> data) {
        GameTerbeli gameTerbeliDitinjau = service.gameTerbeliReview(data.get("idPermainan").toString(), idPengguna);
        return gameTerbeliDitinjau;
    }

    @PatchMapping("/belum-ditinjau/pengguna/{idPengguna}")
    public GameTerbeli gameTerbeliBelumDitinjau(@PathVariable String idPengguna, @RequestBody Map<String, Object> data) {
        GameTerbeli gameTerbeliBelumDitinjau = service.gameTerbeliNoReview(data.get("idPermainan").toString(), idPengguna);
        return gameTerbeliBelumDitinjau;
    }

    @PostMapping("/input")
    public void fetchGameTerbeli(@RequestBody List<Map<String, Object>> gameData) {
        for (Map<String, Object> data : gameData) {
            inputGameTerbeli(data);
        }
    }
}
