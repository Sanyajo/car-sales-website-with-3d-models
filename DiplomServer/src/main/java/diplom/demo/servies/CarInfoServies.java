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
public class CarInfoServies {

    private final CarInfoRepository carInfoRepository;

//    public List<CarInfo> listCarModel(String model, String series){
//        if(model != null){
//            carInfoRepository.findByModel(model);
//        }
//        return carInfoRepository.findAll();
//    }

    public CarInfo listCarSeries(String model, String series) {
        switch (series) {
            case "M": {
                return carInfoRepository.findByModelAndSeries(model, series);
            }
            case "series": {
                return carInfoRepository.findByModelAndSeries(model, series);
            }

            default:{
                return (CarInfo) Collections.emptyList();
            }
        }
    }

}
