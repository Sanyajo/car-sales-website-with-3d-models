package diplom.demo.servies;

import diplom.demo.Repository.TestDriveHumanRepository;
import diplom.demo.models.TestDriveHuman;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestDriveHumanServies {
    private final TestDriveHumanRepository testDriveHumanRepository;


    public void addHuman(String fio, String phoneNumber, String email) {
        if(fio.isEmpty() || phoneNumber.isEmpty()){

        }

        TestDriveHuman testDriveHuman = new TestDriveHuman();
        testDriveHuman.setFullName(fio);
        testDriveHuman.setTelephoneNumber(phoneNumber);
        testDriveHuman.setEmail(email);

        testDriveHumanRepository.save(testDriveHuman);
    }
}
