package diplom.demo.Repository.HumanRepository;

import diplom.demo.models.HumanModels.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ShopUserRepository extends JpaRepository<ShopUser, Long> {

    List<ShopUser> findAll();

}
