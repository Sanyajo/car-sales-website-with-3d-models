package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.models.carModels.Car;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServies {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final CarRepository carRepository;

    public List<Car> listCar(){
        if(carRepository.count() > 0){
            return carRepository.findAll();
        }
        return null;
    }

    public void setMark(String carModel){
       carRepository.findByModel(carModel).setMarkCar("yes");
    }

    public String addCar(String model, String series, String motortype, String seriestype, MultipartFile photo){
        String sql = "INSERT INTO car (model, series, urlimage, motortype, seriestype, mark) VALUES (?, ?, ?, ?, ?, 'no')";

        try {
            Path directory = Paths.get("DiplomServer/src/main/resources/static/images/car");
            Path filePath = directory.resolve(photo.getOriginalFilename());
            Files.write(filePath, photo.getBytes());

            String urlImageStr = "/images/car/" + photo.getOriginalFilename();

            jdbcTemplate.update(sql, model, series, urlImageStr, motortype, seriestype);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Car added successfully";
    }

    public String deleteCar(String carSelection){
        String[] array = carSelection.split(" ");
        String model = array[1];
        String sql = "DELETE FROM car WHERE model= ?";
        jdbcTemplate.update(sql, model);
        return "record car delete !";
    }


}
