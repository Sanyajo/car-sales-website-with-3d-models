package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.ArCarRepository;
import diplom.demo.models.carModels.ArCar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArCarServies {

    private final ArCarRepository arCarRepository;

    public List<ArCar> getAllArCar(){
        if(arCarRepository.count() > 0){
            return arCarRepository.findAll();
        }
        return null;
    }

    public ArCar getCar(String model){
        return arCarRepository.findByModel(model);
    }
}
