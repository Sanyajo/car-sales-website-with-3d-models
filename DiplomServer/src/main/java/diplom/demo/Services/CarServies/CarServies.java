package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.models.carModels.Car;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final CarRepository carRepository;

    public List<Car> listCar(){
        if(carRepository.count() > 0){
            return carRepository.findAll();
        }
        return null;
    }

    public boolean addCar(String model, String series, String motortype, String seriestype, MultipartFile photo, String price){
        String sqlAddCar = "INSERT INTO car (model, series, urlimage, motortype, seriestype, mark, price) VALUES (:model, :series, :urlimage, :motortype, :seriestype, 'no', :price)";

        try {
            Path directory = Paths.get("DiplomServer/src/main/resources/static/images/car");
            Path filePath = directory.resolve(photo.getOriginalFilename());
            Files.write(filePath, photo.getBytes());

            String urlImageStr = "/images/car/" + photo.getOriginalFilename();

            MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
            sqlParameterSource.addValue("model", model);
            sqlParameterSource.addValue("series", series);
            sqlParameterSource.addValue("urlimage", urlImageStr);
            sqlParameterSource.addValue("motortype", motortype);
            sqlParameterSource.addValue("seriestype", seriestype);
            sqlParameterSource.addValue("price", price);

                return (namedParameterJdbcTemplate.update(sqlAddCar, sqlParameterSource) > 0);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCar(String carSelection){
        try {
            String[] array = carSelection.split(" ");
            String model = array[1];
            String sqlDeleteCar = "DELETE FROM car WHERE model=:model";
            String sqlGetUrlCar = "SELECT urlimage FROM car WHERE model=:model";

            MapSqlParameterSource paramGetUrlCar = new MapSqlParameterSource();
            paramGetUrlCar.addValue("model", model);

            String urlImage = namedParameterJdbcTemplate.queryForObject(sqlGetUrlCar, paramGetUrlCar, String.class);

            MapSqlParameterSource paramDelCar = new MapSqlParameterSource();
            paramDelCar.addValue("model", model);

            File file = new File("DiplomServer/src/main/resources/static" + urlImage);
            if (file.delete()) {
                return (namedParameterJdbcTemplate.update(sqlDeleteCar, paramDelCar) > 0);
            }else{
                return false;
            }

        }catch (DataAccessException e){
            log.error("Не удалось удалить запись ", carSelection, e);
            return false;
        }

    }

    public Car getCar(String model){
        return carRepository.findByModel(model);
    }


}
