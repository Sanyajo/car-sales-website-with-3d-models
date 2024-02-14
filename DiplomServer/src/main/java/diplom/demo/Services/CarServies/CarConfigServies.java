package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarConfigRepository;
import diplom.demo.models.carModels.CarConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarConfigServies {

    private final CarConfigRepository carConfigRepository;

    public List<CarConfig> listCarConfiog(String model, String series, String type){
        return carConfigRepository.findByModelAndSeriesAndTypeList(model, series, type);
    }

}
