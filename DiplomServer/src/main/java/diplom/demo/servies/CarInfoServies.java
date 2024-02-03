package diplom.demo.servies;

import diplom.demo.Repository.CarInfoRepository;
import diplom.demo.Repository.CarRepository;
import diplom.demo.models.Car;
import diplom.demo.models.CarInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarInfoServies {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final CarInfoRepository carInfoRepository;

//    public List<CarInfo> listCarModel(String model, String series){
//        if(model != null){
//            carInfoRepository.findByModel(model);
//        }
//        return carInfoRepository.findAll();
//    }

    public CarInfo listCarSeries(String model, String seriestype) {
        switch (seriestype) {
            case "M": {
                return carInfoRepository.findByModelAndSeriestype(model, seriestype);
            }
            case "stock": {
                return carInfoRepository.findByModelAndSeriestype(model, seriestype);
            }

            default:{
                return (CarInfo) Collections.emptyList();
            }
        }
    }

    public String getCarPDFUrl(String model, String series){
        String pdfURL = carInfoRepository.findByModelAndSeriestype(model, series).getPdfurl();
        return pdfURL;
//       return carInfoRepository.findByModelAndSeries(model, series);
    }

    public String getMotorType(String model, String seriestype) {
        String sql = "SELECT c.motortype " +
                "FROM car c " +
                "JOIN carinfo ci ON c.model = ci.model AND c.seriestype = ci.seriestype " +
                "WHERE c.model = ? AND ci.seriestype = ?";
        return jdbcTemplate.queryForObject(sql, String.class, model, seriestype);
    }



}
