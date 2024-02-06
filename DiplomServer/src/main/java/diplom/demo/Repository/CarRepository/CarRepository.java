package diplom.demo.Repository.CarRepository;

import diplom.demo.models.carModels.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository  extends JpaRepository<Car, Long> {

    Car findByModel(String model);

    List<Car> findByModelAndSeries(String carModel, String series);
}

