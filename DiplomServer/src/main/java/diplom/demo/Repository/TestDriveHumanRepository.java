package diplom.demo.Repository;

import diplom.demo.models.CarInfo;
import diplom.demo.models.TestDriveHuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestDriveHumanRepository  extends JpaRepository<TestDriveHuman, Long> {

//    @Imsert("INSERT INTO testdrivehuman (fullname, telephonenumber, email, mark) VALUES (fio, phoneNumber, email)")
//    TestDriveHuman add(String fio, String phoneNumber, String email);

    List<TestDriveHuman> findAll();
}
