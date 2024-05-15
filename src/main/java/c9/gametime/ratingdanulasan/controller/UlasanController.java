package c9.gametime.ratingdanulasan.controller;
import c9.gametime.ratingdanulasan.model.Ulasan;
import c9.gametime.ratingdanulasan.service.UlasanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/ulasan")
public class UlasanController {
    private final UlasanService ulasanService;

    @Autowired
    public UlasanController(UlasanService ulasanService) {
        this.ulasanService = ulasanService;
    }

    @GetMapping
    public String lihatSemuaUlasan(Model model) {
        model.addAttribute("ulasan", ulasanService.temukanSemuaUlasan());
        return "ulasan";
    }

    @PostMapping("/tambah")
    public String tambahUlasan(@ModelAttribute Ulasan ulasan) {
        ulasanService.simpanUlasan(ulasan);
        return "redirect:/ulasan";
    }

    @GetMapping("/{id}")
    public String lihatUlasanById(@PathVariable Long id, Model model) {
        Optional<Ulasan> ulasan = ulasanService.temukanUlasanById(id);
        if (ulasan.isPresent()) {
            model.addAttribute("ulasan", ulasan.get());
            return "detail-ulasan";
        }
        return "redirect:/ulasan";
    }

    @PostMapping("/perbarui/{id}")
    public String perbaruiUlasan(@PathVariable Long id, @ModelAttribute Ulasan ulasan) {
        ulasanService.perbaruiUlasan(id, ulasan);
        return "redirect:/ulasan";
    }

    @PostMapping("/hapus/{id}")
    public String hapusUlasan(@PathVariable Long id) {
        ulasanService.hapusUlasan(id);
        return "redirect:/ulasan";
    }
}
