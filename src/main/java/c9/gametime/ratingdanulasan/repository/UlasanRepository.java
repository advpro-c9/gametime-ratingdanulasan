package c9.gametime.ratingdanulasan.repository;

import c9.gametime.ratingdanulasan.model.Ulasan;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UlasanRepository {
    private List<Ulasan> ulasanData = new ArrayList<>();

    public Ulasan simpan(Ulasan ulasan) {
        ulasanData.add(ulasan);
        return ulasan;
    }

    public Iterator<Ulasan> temukanSemua() {
        return ulasanData.iterator();
    }

    public Optional<Ulasan> temukanById(Long id) {
        return ulasanData.stream().filter(ulasan -> ulasan.getId().equals(id)).findFirst();
    }

    public Ulasan perbarui(Long id, Ulasan ulasanYangDiperbarui) {
        for (int i = 0; i < ulasanData.size(); i++) {
            Ulasan ulasan = ulasanData.get(i);
            if (ulasan.getId().equals(id)) {
                ulasan.setGameId(ulasanYangDiperbarui.getGameId());
                ulasan.setUserId(ulasanYangDiperbarui.getUserId());
                ulasan.setComment(ulasanYangDiperbarui.getComment());
                ulasan.setRating(ulasanYangDiperbarui.getRating());
                return ulasan;
            }
        }
        return null;
    }

    public void hapus(Long id) {
        ulasanData.removeIf(ulasan -> ulasan.getId().equals(id));
    }
}
