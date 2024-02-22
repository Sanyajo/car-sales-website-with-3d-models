package diplom.demo.Services.HumanServies;

import diplom.demo.Repository.HumanRepository.ShopUserRepository;
import diplom.demo.models.HumanModels.ShopUser;
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
public class ShopUserServies {
    private final ShopUserRepository shopUserRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ShopUser> allShopUser(){
        return shopUserRepository.findAll();
    }

    public boolean addUserShop(String fullname, String phoneNumber, String car, String email){
        String sqlAddUser = "INSERT INTO shopuser (fullname, phoneNumber, email, car) VALUES (:fullname, :phoneNumber, :email, :car)";

        MapSqlParameterSource sqlParamAddUser = new MapSqlParameterSource();
        sqlParamAddUser.addValue("fullname", fullname);
        sqlParamAddUser.addValue("phoneNumber", phoneNumber);
        sqlParamAddUser.addValue("email", email);
        sqlParamAddUser.addValue("car", car);

        return (namedParameterJdbcTemplate.update(sqlAddUser, sqlParamAddUser) > 0);

    }
}
