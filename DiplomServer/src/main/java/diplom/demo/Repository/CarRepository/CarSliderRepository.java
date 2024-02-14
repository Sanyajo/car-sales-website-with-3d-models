package diplom.demo.Repository.CarRepository;

import diplom.demo.models.carModels.CarSlider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarSliderRepository extends JpaRepository<CarSlider, Long> {
     List<CarSlider> findByModelAndSeriestypeAndType(String model, String seriestype, String type);
     List<CarSlider> findAll();

}
