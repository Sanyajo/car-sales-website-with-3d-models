package diplom.demo.Controller;


import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.models.carModels.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarRequestMapping {

    @Autowired
    private CarRepository carRepository;

    public CarRequestMapping(){

    }

    @PutMapping("/{id}/yes")
    public void updateCarMarkYes(@PathVariable Long id, @RequestParam("carModel") String carModel) {
        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(carModel));
        optionalCar.ifPresent(car -> {
            car.setMarkCar("yes");
            carRepository.save(car);
        });
    }

    @PutMapping("/{id}/no")
    public void updateCarMarkNo(@PathVariable Long id, @RequestParam("carModel") String carModel) {
        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(carModel));
        optionalCar.ifPresent(car -> {
            car.setMarkCar("no");
            carRepository.save(car);
        });
    }
}
