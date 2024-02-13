package diplom.demo.Services.HumanServies;

import diplom.demo.Repository.HumanRepository.ShopUserRepository;
import diplom.demo.models.HumanModels.ShopUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopUserServies {
    private final ShopUserRepository shopUserRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ShopUser> allShopUser(){
        return shopUserRepository.findAll();
    }

    public String addUserShop(String fio, String phoneNumber, String car, String email){
        String sql = "INSERT INTO shopuser (fullname, phonenumber, email, car) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, fio, phoneNumber, email, car);
        return "Пользователь на покупку записан !";
    }
}
