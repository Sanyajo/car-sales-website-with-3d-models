package diplom.demo.Services.HumanServies;

import diplom.demo.Repository.HumanRepository.TestDriveHumanRepository;
import diplom.demo.models.HumanModels.TestDriveHuman;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestDriveHumanServies {
    private final TestDriveHumanRepository testDriveHumanRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public boolean addHuman(String fullName, String telephoneNumber, String car, String email) {

        String sqlAddHuman = "INSERT INTO testdrivehuman (fullname, telephonenumber, email, mark, car) VALUES (:fullname, :telephonenumber, :email, 'no', :car)";

        MapSqlParameterSource sqlParamAddHuman = new MapSqlParameterSource();
        sqlParamAddHuman.addValue("fullname", fullName);
        sqlParamAddHuman.addValue("telephonenumber", telephoneNumber);
        sqlParamAddHuman.addValue("email", email);
        sqlParamAddHuman.addValue("car", car);

        return (namedParameterJdbcTemplate.update(sqlAddHuman, sqlParamAddHuman) > 0);
    }

    public List<TestDriveHuman> allHuman(){
        return testDriveHumanRepository.findAll();
    }


}
