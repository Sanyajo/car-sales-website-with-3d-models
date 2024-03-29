package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarInfoRepository;
import diplom.demo.models.carModels.CarInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Collections;
@Service
@RequiredArgsConstructor
@Slf4j
public class CarInfoServies {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final CarInfoRepository carInfoRepository;

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

    public String getMotorType(String model, String seriestype) {
        String sql = "SELECT c.motortype " +
                "FROM car c " +
                "JOIN carinfo ci ON c.model = ci.model AND c.seriestype = ci.seriestype " +
                "WHERE c.model = ? AND ci.seriestype = ?";
        return jdbcTemplate.queryForObject(sql, String.class, model, seriestype);

    }

}
