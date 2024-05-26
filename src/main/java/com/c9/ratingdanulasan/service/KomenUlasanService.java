package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.KomenUlasan;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface KomenUlasanService {
    CompletableFuture<KomenUlasan> createKomenUlasan(KomenUlasan komenUlasan);
    CompletableFuture<KomenUlasan> updateKomenUlasan(KomenUlasan komenUlasan);
    CompletableFuture<Void> deleteKomenUlasan(String id);
    CompletableFuture<Optional<KomenUlasan>> findKomenUlasanById(String id);
    CompletableFuture<Optional<KomenUlasan>> findKomenUlasanByUlasanId(String ulasanId);
    CompletableFuture<List<KomenUlasan>> findAllKomenUlasan();
    CompletableFuture<List<KomenUlasan>> findAllKomenUlasanByPenjualId(String penjualId);
}
