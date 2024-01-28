package diplom.demo.servies;

import diplom.demo.Repository.CarSliderRepository;
import diplom.demo.models.CarSlider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarSliderServies {
    private final CarSliderRepository carSliderRepository;

    public List<CarSlider> listSliderImage(String model, String series, String type){
        return carSliderRepository.findByModelAndSeriesAndType(model, series, type);
    }
}
