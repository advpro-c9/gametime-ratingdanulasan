package com.c9.ratingdanulasan.repository;

import com.c9.ratingdanulasan.model.Ulasan;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UlasanRepository {
    private final UUID uuid = UUID.randomUUID();
    private final List<Ulasan> ulasanData = new ArrayList<>();

    public Ulasan create(Ulasan ulasan){
        if (ulasan.getId() == null) {
            ulasan.setId(uuid.randomUUID().toString());
        }
        ulasanData.add(ulasan);
        return ulasan;
    }

    public Iterator<Ulasan> findAll(){
        return ulasanData.iterator();
    }

    public List<Ulasan> findAllByUserId(Long userId) {
        List<Ulasan> ulasanByUser = new ArrayList<>();
        for (Ulasan ulasan : ulasanData) {
            if (ulasan.getUserId().equals(userId)) {
                ulasanByUser.add(ulasan);
            }
        }
        return ulasanByUser;
    }

    public List<Ulasan> findAllByGameId(Long gameId) {
        List<Ulasan> ulasanByGame = new ArrayList<>();
        for (Ulasan ulasan : ulasanData) {
            if (ulasan.getGameId().equals(gameId)) {
                ulasanByGame.add(ulasan);
            }
        }
        return ulasanByGame;
    }

    public Ulasan findById(String ulasanId) {
        return ulasanData.stream()
                .filter(ulasan -> ulasan.getId().equals(ulasanId))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid ulasan Id:" + ulasanId)
                );
    }

    public Ulasan edit(Ulasan editedUlasan) {
        String ulasanId = editedUlasan.getId();
        Ulasan existingUlasan = findById(ulasanId);
        int indexOfUlasan = ulasanData.indexOf(existingUlasan);

        ulasanData.set(indexOfUlasan, editedUlasan);
        return editedUlasan;
    }

    public Ulasan delete(String ulasanId) {
        Ulasan ulasan = findById(ulasanId);
        ulasanData.remove(ulasan);
        return ulasan;
    }
}
