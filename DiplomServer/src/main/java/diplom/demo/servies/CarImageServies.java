package diplom.demo.servies;

import diplom.demo.Repository.CarImageRepository;
import diplom.demo.models.CarImageUrl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarImageServies {

    private final CarImageRepository carImageRepository;

    public CarImageUrl funct(String model, String seriestype){
        return carImageRepository.findCarUrlTitle(model, seriestype);
    }

}
