package diplom.demo.Controller;


import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.Repository.HumanRepository.TestDriveHumanRepository;
import diplom.demo.Services.CarServies.CarServies;
import diplom.demo.Services.HumanServies.UsersServies;
import diplom.demo.models.HumanModels.TestDriveHuman;
import diplom.demo.models.carModels.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/humans")
public class HumanController {


    @Autowired
    private TestDriveHumanRepository testDriveHumanRepository;

    @Autowired
    private CarRepository carRepository;


    public HumanController() {
    }

    @PutMapping("/{id}/yes")
    public void updateMarkYes(@PathVariable Long id, @RequestParam("testdrivecar") String testdrivecar) {
        Optional<TestDriveHuman> optionalHuman = testDriveHumanRepository.findById(id);
        optionalHuman.ifPresent(human -> {
            human.setMark("yes");
            testDriveHumanRepository.save(human);
        });

        String[] array = testdrivecar.split(" ");
        String model = array[1];

        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(model));
        optionalCar.ifPresent(car -> {
            car.setMarkCar("yes");
            carRepository.save(car);
        });

    }

    @PutMapping("/{id}/no")
    public void updateMarkNo(@PathVariable Long id,  @RequestParam("testdrivecar") String testdrivecar) {
        Optional<TestDriveHuman> optionalHuman = testDriveHumanRepository.findById(id);
        optionalHuman.ifPresent(human -> {
            human.setMark("no");
            testDriveHumanRepository.save(human);
        });

        String[] array = testdrivecar.split(" ");
        String model = array[1];

        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(model));
        optionalCar.ifPresent(car -> {
            car.setMarkCar("no");
            carRepository.save(car);
        });
    }
}