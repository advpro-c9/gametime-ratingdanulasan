package com.c9.ratingdanulasan.service;

import com.c9.ratingdanulasan.model.Ulasan;
import com.c9.ratingdanulasan.repository.UlasanRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class UlasanServiceImpl implements UlasanService {

    private final UlasanRepository ulasanRepository;

    private UlasanServiceImpl(UlasanRepository ulasanRepository) {
        this.ulasanRepository = ulasanRepository;
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<Ulasan> createUlasan(Ulasan ulasan) {
        return CompletableFuture.supplyAsync(() -> {
            Ulasan savedUlasan = ulasanRepository.save(ulasan);
            return savedUlasan;
        });
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<List<Ulasan>> findAllUlasan() {
        return CompletableFuture.completedFuture(ulasanRepository.findAll());
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<List<Ulasan>> findUlasanByUserId(String userId) {
        return CompletableFuture.completedFuture(ulasanRepository.findAllByUserId(userId));
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<List<Ulasan>> findUlasanByGameId(String gameId) {
        return CompletableFuture.completedFuture(ulasanRepository.findAllByPermainan(gameId));
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<Optional<Ulasan>> findUlasanById(String ulasanId) {
        return CompletableFuture.completedFuture(ulasanRepository.findById(ulasanId));
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<Ulasan> updateUlasan(Ulasan ulasan) {
        return CompletableFuture.completedFuture(ulasanRepository.save(ulasan));
    }

    @Async("taskExecutor")
    @Override
    public void deleteUlasan(String idUlasan) {
        ulasanRepository.deleteById(idUlasan);
    }
}
