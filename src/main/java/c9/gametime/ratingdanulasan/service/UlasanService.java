package c9.gametime.ratingdanulasan.service;
import c9.gametime.ratingdanulasan.model.Ulasan;
import c9.gametime.ratingdanulasan.repository.UlasanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.Optional;

@Service
public class UlasanService {
    private final UlasanRepository ulasanRepository;

    @Autowired
    public UlasanService(UlasanRepository ulasanRepository) {
        this.ulasanRepository = ulasanRepository;
    }

    public Ulasan simpanUlasan(Ulasan ulasan) {
        return ulasanRepository.simpan(ulasan);
    }

    public Iterator<Ulasan> temukanSemuaUlasan() {
        return ulasanRepository.temukanSemua();
    }

    public Optional<Ulasan> temukanUlasanById(Long id) {
        return ulasanRepository.temukanById(id);
    }

    public Ulasan perbaruiUlasan(Long id, Ulasan ulasanYangDiperbarui) {
        return ulasanRepository.perbarui(id, ulasanYangDiperbarui);
    }

    public void hapusUlasan(Long id) {
        ulasanRepository.hapus(id);
    }
}

