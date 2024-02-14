package diplom.demo.Repository.CarRepository;

import diplom.demo.models.carModels.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car, Long> {
    Car findByModel(String model);
}

