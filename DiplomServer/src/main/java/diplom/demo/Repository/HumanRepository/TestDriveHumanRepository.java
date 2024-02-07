package diplom.demo.Repository.HumanRepository;

import diplom.demo.models.HumanModels.TestDriveHuman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestDriveHumanRepository  extends JpaRepository<TestDriveHuman, Long> {

//    @Imsert("INSERT INTO testdrivehuman (fullname, telephonenumber, email, mark) VALUES (fio, phoneNumber, email)")
//    TestDriveHuman add(String fio, String phoneNumber, String email);

    List<TestDriveHuman> findAll();

    Optional<TestDriveHuman> findByTestDriveCar(String car);
}
