package diplom.demo.servies;

import diplom.demo.Repository.CarConfigRepository;
import diplom.demo.models.CarConfig;
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

//    public CarConfig carConfigF(String model, String series, String type){
//        return carConfigRepository.findByModelAndSeriesAndType(model, series, type);
//    }
}
