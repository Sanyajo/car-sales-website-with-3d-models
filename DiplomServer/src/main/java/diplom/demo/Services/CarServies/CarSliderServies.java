package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarSliderRepository;
import diplom.demo.models.carModels.Car;
import diplom.demo.models.carModels.CarSlider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarSliderServies {
    private final CarSliderRepository carSliderRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CarSlider> listSliderImage(String model, String seriestype, String type){
        return carSliderRepository.findByModelAndSeriestypeAndType(model, seriestype, type);
    }

    public Set<String> getTableColumnNames() {
        String sql = "SELECT * FROM slidertable";
        Set<String> columnNamesSet = new HashSet<>();

        jdbcTemplate.query(sql, rs -> {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 2; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnNamesSet.add(columnName);
            }
        });

        return columnNamesSet;
    }

    public List<CarSlider> allCarSlider(){
        return carSliderRepository.findAll();
    }
}
