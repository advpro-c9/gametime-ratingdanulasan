package com.c9.ratingdanulasan.repository;

import com.c9.ratingdanulasan.model.GameTerbeli;
import com.c9.ratingdanulasan.model.GameTerbeliId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameTerbeliRepository extends JpaRepository<GameTerbeli, GameTerbeliId> {
    List<GameTerbeli> findAllByUserId(String userId);
    GameTerbeli findByGameIdAndUserId(String gameId, String userId);
}
