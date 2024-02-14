package diplom.demo.Repository.HumanRepository;

import diplom.demo.models.HumanModels.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserLogin(String userLogin);
}
