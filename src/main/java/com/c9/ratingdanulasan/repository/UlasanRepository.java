package com.c9.ratingdanulasan.repository;

import com.c9.ratingdanulasan.model.Ulasan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UlasanRepository extends JpaRepository<Ulasan, String> {
    List<Ulasan> findAllByIdPengguna(String idPengguna);
    List<Ulasan> findAllByPermainan(String permainan);
}
