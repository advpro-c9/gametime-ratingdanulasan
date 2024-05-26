package com.c9.ratingdanulasan.repository;

import com.c9.ratingdanulasan.model.KomenUlasan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomenUlasanRepository extends JpaRepository<KomenUlasan, String> {
    KomenUlasan findByUlasanId(String ulasanId);
    List<KomenUlasan> findAllByPenjualId(String penjualId);
}
