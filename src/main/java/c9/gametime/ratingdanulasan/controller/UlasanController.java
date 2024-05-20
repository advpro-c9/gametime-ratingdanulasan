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
    public String findAllUlasan(Model model) {
        model.addAttribute("ulasan", ulasanService.findAllUlasan());
        return "ulasan";
    }

    @PostMapping("/tambah")
    public String tambahUlasan(@ModelAttribute Ulasan ulasan) {
        ulasanService.saveUlasan(ulasan);
        return "redirect:/ulasan";
    }

    @GetMapping("/{id}")
    public String findUlasanById(@PathVariable Long id, Model model) {
        Optional<Ulasan> ulasan = ulasanService.findUlasanById(id);
        if (ulasan.isPresent()) {
            model.addAttribute("ulasan", ulasan.get());
            return "detail-ulasan";
        }
        return "redirect:/ulasan";
    }

    @PostMapping("/perbarui/{id}")
    public String updateUlasan(@PathVariable Long id, @ModelAttribute Ulasan ulasan) {
        ulasanService.updateUlasan(id, ulasan);
        return "redirect:/ulasan";
    }

    @PostMapping("/hapus/{id}")
    public String deleteUlasan(@PathVariable Long id) {
        ulasanService.deleteUlasan(id);
        return "redirect:/ulasan";
    }
}
