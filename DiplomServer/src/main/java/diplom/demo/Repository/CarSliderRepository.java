package diplom.demo.Repository;

import diplom.demo.models.CarSlider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarSliderRepository extends JpaRepository<CarSlider, Long> {
//    @Query("SELECT c FROM CarImageUrl c WHERE c.model = :model AND c.series = :series AND c.type = :type")
     List<CarSlider> findByModelAndSeriestypeAndType(String model, String seriestype, String type);

}
