package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.KomenUlasan;
import com.c9.ratingdanulasan.repository.KomenUlasanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class KomenUlasanServiceImpl implements KomenUlasanService {

    private final KomenUlasanRepository komenUlasanRepository;

    private KomenUlasanServiceImpl(KomenUlasanRepository komenUlasanRepository) {
        this.komenUlasanRepository = komenUlasanRepository;
    }

    @Override
    public CompletableFuture<KomenUlasan> createKomenUlasan(KomenUlasan komenUlasan) {
        return CompletableFuture.completedFuture(komenUlasanRepository.save(komenUlasan));
    }

    @Override
    public CompletableFuture<KomenUlasan> updateKomenUlasan(KomenUlasan komenUlasan) {
        return CompletableFuture.completedFuture(komenUlasanRepository.save(komenUlasan));
    }

    @Override
    public CompletableFuture<Void> deleteKomenUlasan(String id) {
        komenUlasanRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Optional<KomenUlasan>> findKomenUlasanById(String id) {
        return CompletableFuture.completedFuture(komenUlasanRepository.findById(id));
    }

    @Override
    public CompletableFuture<Optional<KomenUlasan>> findKomenUlasanByUlasanId(String ulasanId) {
        return CompletableFuture.completedFuture(Optional.ofNullable(komenUlasanRepository.findByUlasanId(ulasanId)));
    }

    @Override
    public CompletableFuture<List<KomenUlasan>> findAllKomenUlasan() {
        return CompletableFuture.completedFuture(komenUlasanRepository.findAll());
    }

    @Override
    public CompletableFuture<List<KomenUlasan>> findAllKomenUlasanByPenjualId(String penjualId) {
        return CompletableFuture.completedFuture(komenUlasanRepository.findAllByPenjualId(penjualId));
    }
}
