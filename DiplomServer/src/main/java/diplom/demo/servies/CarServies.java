package diplom.demo.servies;

import diplom.demo.Repository.CarInfoRepository;
import diplom.demo.Repository.CarRepository;
import diplom.demo.models.Car;
import diplom.demo.models.CarInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
