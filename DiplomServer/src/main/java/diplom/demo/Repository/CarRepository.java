package diplom.demo.Repository;

import diplom.demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository  extends JpaRepository<Car, Long> {

    List<Car> findByModel(String model);
}

