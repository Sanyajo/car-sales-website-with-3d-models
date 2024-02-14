package diplom.demo.Repository.HumanRepository;

import diplom.demo.models.HumanModels.TestDriveHuman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestDriveHumanRepository  extends JpaRepository<TestDriveHuman, Long> {
    List<TestDriveHuman> findAll();
    Optional<TestDriveHuman> findByTestDriveCar(String car);
}
