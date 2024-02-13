package diplom.demo.Repository.HumanRepository;

import diplom.demo.models.HumanModels.ShopUser;
import diplom.demo.models.HumanModels.TestDriveHuman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface ShopUserRepository extends JpaRepository<ShopUser, Long> {

    List<ShopUser> findAll();

}
