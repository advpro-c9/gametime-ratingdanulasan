package com.c9.ratingdanulasan.controller;

import com.c9.ratingdanulasan.model.KomenUlasan;
import com.c9.ratingdanulasan.service.KomenUlasanService;
import com.c9.ratingdanulasan.service.UlasanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/ratingdanulasan")
public class KomenUlasanController {

    private final UlasanService ulasanService;
    private final KomenUlasanService service;

    private KomenUlasanController(UlasanService ulasanService, KomenUlasanService service) {
        this.ulasanService = ulasanService;
        this.service = service;
    }

    @PostMapping("/buat")
    public CompletableFuture<ResponseEntity<String>> buatKomenUlasan(@RequestBody Map<String, Object> data) {
        return ulasanService.findUlasanById(data.get("ulasan").toString()).thenApply(ulasanOptional -> ulasanOptional.map(ulasan -> {
            KomenUlasan komenUlasan = new KomenUlasan.Builder()
                    .id(UUID.randomUUID().toString())
                    .penjualId(data.get("idPenjual").toString())
                    .ulasan(ulasan)
                    .komen(data.get("komen").toString())
                    .date(LocalDate.now())
                    .build();
            service.createKomenUlasan(komenUlasan);
            return ResponseEntity.ok("Komen berhasil dibuat");
        }).orElseGet(() -> ResponseEntity.badRequest().body("Ulasan tidak ditemukan")));
    }

    @GetMapping("/{idKomen}")
    public CompletableFuture<ResponseEntity<KomenUlasan>> dapatkanKomen(@PathVariable String id) {
        return service.findKomenUlasanById(id)
                .thenApply(komenUlasan -> komenUlasan.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @GetMapping("/penjual/{idPenjual}")
    public CompletableFuture<ResponseEntity<List<KomenUlasan>>> semuaKomenPenjual(@PathVariable String penjualId) {
        return service.findAllKomenUlasanByPenjualId(penjualId)
                .thenApply(listKomen -> {
                    if (listKomen.isEmpty()) {
                        return ResponseEntity.notFound().build();
                    }
                    return ResponseEntity.ok(listKomen);
                });
    }

    @PatchMapping("/edit/{idKomen}")
    public CompletableFuture<ResponseEntity<String>> editKomen(@PathVariable String idKomen, @RequestBody Map<String, Object> data) {
        return service.findKomenUlasanById(idKomen).thenApply(komenOptional -> komenOptional.map(komen -> {
            komen.setKomen(data.get("komen").toString());
            komen.setDate(LocalDate.now());
            service.updateKomenUlasan(komen);
            return ResponseEntity.ok("Komen berhasil diperbarui");
        }).orElseGet(() -> ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/hapus/{idKomen}")
    public CompletableFuture<ResponseEntity<String>> hapusKomen(@PathVariable String idKomen) {
        return service.findKomenUlasanById(idKomen).thenApply(komenOptional -> komenOptional.map(komen -> {
            service.deleteKomenUlasan(idKomen);
            return ResponseEntity.ok("Komen berhasil dihapus");
        }).orElseGet(() -> ResponseEntity.notFound().build()));
    }
}
