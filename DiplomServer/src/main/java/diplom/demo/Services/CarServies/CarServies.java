package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.models.carModels.Car;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServies {

    private final CarRepository carRepository;

    public List<Car> listCar(){
        if(carRepository.count() > 0){
            return carRepository.findAll();
        }
        return null;
    }


}
