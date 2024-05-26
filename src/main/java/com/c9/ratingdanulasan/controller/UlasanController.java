package com.c9.ratingdanulasan.controller;

import com.c9.ratingdanulasan.model.Ulasan;
import com.c9.ratingdanulasan.service.UlasanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;


@Controller
@RequestMapping("/ulasan")
public class UlasanController {

    private final UlasanService ulasanService;

    @Autowired
    public UlasanController(UlasanService ulasanService) {
        this.ulasanService = ulasanService;
    }

    @PostMapping("/add")
    public CompletableFuture<ResponseEntity<Ulasan>> addUlasan(@RequestBody Map<String, Object> data) {
        Ulasan ulasan = new Ulasan();
        ulasan.setId(UUID.randomUUID().toString());
        ulasan.setUserId(Long.parseLong(data.get("idUser").toString()));
        ulasan.setGameId(Long.parseLong(data.get("gameId").toString()));
        ulasan.setRating(Integer.parseInt(data.get("rating").toString()));
        ulasan.setComment(data.get("deskripsi").toString());
        ulasan.setDate(LocalDate.now());

        return ulasanService.createUlasan(ulasan).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Ulasan>> findUlasanById(@PathVariable String id) {
        return ulasanService.findUlasanById(id)
                .thenApply(ulasan -> ulasan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @GetMapping("/user/{userId}")
    public CompletableFuture<ResponseEntity<List<Ulasan>>> findUlasanByUserId(@PathVariable Long userId) {
        return ulasanService.findUlasansByUserId(userId)
                .thenApply(ulasans -> ulasans.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(ulasans));
    }

    @GetMapping("/game/{gameId}")
    public CompletableFuture<ResponseEntity<List<Ulasan>>> findUlasanByGameId(@PathVariable Long gameId) {
        return ulasanService.findUlasansByGameId(gameId)
                .thenApply(ulasans -> ulasans.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(ulasans));
    }

    @PostMapping("/update/{id}")
    public CompletableFuture<ResponseEntity<String>> updateUlasan(@PathVariable String id, @RequestBody Map<String, Object> data) {
        return ulasanService.findUlasanById(id).thenApply(ulasanOptional -> ulasanOptional.map(ulasan -> {
            ulasan.setComment(data.get("deskripsi").toString());
            ulasan.setRating(Integer.parseInt(data.get("rating").toString()));
            ulasan.setDate(LocalDate.now());
            ulasanService.updateUlasan(ulasan);
            return ResponseEntity.ok("Ulasan updated successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @PostMapping("/delete/{id}")
    public CompletableFuture<ResponseEntity<String>> deleteUlasan(@PathVariable String id) {
        return ulasanService.findUlasanById(id).thenApply(ulasanOptional -> ulasanOptional.map(ulasan -> {
            ulasanService.deleteUlasan(id);
            return ResponseEntity.ok("Ulasan deleted successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build()));
    }
}
