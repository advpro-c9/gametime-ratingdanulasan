package c9.gametime.ratingdanulasan.repository;

import c9.gametime.ratingdanulasan.model.Ulasan;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UlasanRepository {
    private List<Ulasan> ulasanData = new ArrayList<>();

    public Ulasan save(Ulasan ulasan) {
        ulasanData.add(ulasan);
        return ulasan;
    }

    public List<Ulasan> findAll() {
        return new ArrayList<>(ulasanData);
    }

    public Optional<Ulasan> findById(Long id) {
        return ulasanData.stream().filter(ulasan -> ulasan.getId().equals(id)).findFirst();
    }

    public Ulasan update(Long id, Ulasan ulasanYangDiperbarui) {
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

    public void delete(Long id) {
        ulasanData.removeIf(ulasan -> ulasan.getId().equals(id));
    }
}
