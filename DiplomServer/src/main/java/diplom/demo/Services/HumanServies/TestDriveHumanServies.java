package diplom.demo.Services.HumanServies;

import diplom.demo.Repository.HumanRepository.TestDriveHumanRepository;
import diplom.demo.models.HumanModels.TestDriveHuman;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestDriveHumanServies {
    private final TestDriveHumanRepository testDriveHumanRepository;


    public void addHuman(String fio, String phoneNumber, String car, String email) {
        TestDriveHuman testDriveHuman = new TestDriveHuman();
        testDriveHuman.setFullName(fio);
        testDriveHuman.setTelephoneNumber(phoneNumber);
        testDriveHuman.setMark("no");
        testDriveHuman.setTestDriveCar(car);
        testDriveHuman.setEmail(email);

        testDriveHumanRepository.save(testDriveHuman);
    }

    public List<TestDriveHuman> allHuman(){
        return testDriveHumanRepository.findAll();
    }


}
