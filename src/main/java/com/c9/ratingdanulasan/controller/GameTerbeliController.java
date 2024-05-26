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
                data.get("gameId").toString(),
                data.get("userId").toString()
        );
        return service.inputGameTerbeli(gameTerbeli);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GameTerbeli>> getGameTerbeliUser(@PathVariable String userId){
        List<GameTerbeli> gameTerbeliList = service.getGameTerbeliByUserId(userId);
        return ResponseEntity.ok(gameTerbeliList);
    }

    @PatchMapping("/sudah-dikomen/user/{userId}")
    public GameTerbeli gameTerbeliDikomen(@PathVariable String userId, @RequestBody Map<String, Object> data) {
        GameTerbeli gameTerbeliDikomen = service.gameTerbeliReview(data.get("gameId").toString(), userId);
        return gameTerbeliDikomen;
    }

    @PatchMapping("/belum-dikomen/user/{userId}")
    public GameTerbeli gameTerbeliBelumDikomen(@PathVariable String userId, @RequestBody Map<String, Object> data) {
        GameTerbeli gameTerbeliBelumDikomen = service.gameTerbeliNoReview(data.get("gameId").toString(), userId);
        return gameTerbeliBelumDikomen;
    }

    @PostMapping("/input")
    public void fetchGameTerbeli(@RequestBody List<Map<String, Object>> gameData) {
        for (Map<String, Object> data : gameData) {
            inputGameTerbeli(data);
        }
    }
}
