package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.Ulasan;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface UlasanService {
    CompletableFuture<Ulasan> createUlasan(Ulasan ulasan);
    CompletableFuture<List<Ulasan>> findAllUlasans();
    CompletableFuture<List<Ulasan>> findUlasansByUserId(Long userId);
    CompletableFuture<List<Ulasan>> findUlasansByGameId(Long gameId);
    CompletableFuture<Optional<Ulasan>> findUlasanById(String ulasanId);
    CompletableFuture<Ulasan> updateUlasan(Ulasan ulasan);
    void deleteUlasan(String ulasanId);
}
