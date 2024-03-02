package diplom.demo.Repository.CarRepository;

import diplom.demo.models.carModels.ArCar;
import diplom.demo.models.carModels.CarConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArCarRepository extends JpaRepository<ArCar, Long> {

    List<ArCar> findAll();

    ArCar findByModel(String model);
}
