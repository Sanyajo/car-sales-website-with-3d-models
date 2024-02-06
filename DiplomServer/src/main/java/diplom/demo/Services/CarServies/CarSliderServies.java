package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarSliderRepository;
import diplom.demo.models.carModels.CarSlider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarSliderServies {
    private final CarSliderRepository carSliderRepository;

    public List<CarSlider> listSliderImage(String model, String seriestype, String type){
        return carSliderRepository.findByModelAndSeriestypeAndType(model, seriestype, type);
    }
}
