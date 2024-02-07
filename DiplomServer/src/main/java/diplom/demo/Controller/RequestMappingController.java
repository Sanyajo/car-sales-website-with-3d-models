package diplom.demo.Controller;


import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.Repository.HumanRepository.TestDriveHumanRepository;
import diplom.demo.models.HumanModels.TestDriveHuman;
import diplom.demo.models.carModels.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class RequestMappingController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestDriveHumanRepository testDriveHumanRepository;

    public RequestMappingController(){

    }

    @PutMapping("/{id}/serviceYes")
    public void updateCarMarkYes(@PathVariable Long id, @RequestParam("carModel") String carModel, @RequestParam("carseries") String carseries) {

        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(carModel));

        Car car = carRepository.findByModel(carModel);
        String filtrCarHuman = "";
        if(car.getSeriestype().equals("M")){
            filtrCarHuman = car.getSeriestype()+car.getSeries() + " " + car.getModel();
        }else{
            filtrCarHuman = car.getSeries() + " " + car.getModel();
        }

        Optional<TestDriveHuman> optionalTestDriveHuman = testDriveHumanRepository.findByTestDriveCar(filtrCarHuman);



        optionalCar.ifPresent(cars -> {
            if(optionalTestDriveHuman.isEmpty()){
                cars.setMarkCar("service");
                carRepository.save(cars);
            }else{
                optionalTestDriveHuman.ifPresent(human ->{
                    cars.setMarkCar("service");
                    carRepository.save(cars);

                    human.setMark("carinservice");
                    testDriveHumanRepository.save(human);
                });
            }
        });
    }

    @PutMapping("{id}/serviceNo")
    public void updateCarMarkNo(@PathVariable Long id, @RequestParam("carModel") String carModel) {
        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(carModel));
        optionalCar.ifPresent(car -> {
            car.setMarkCar("no");
            carRepository.save(car);
        });
    }

    @PutMapping("/{id}/yes")
    public void updateMarkYes(@PathVariable Long id, @RequestParam("testdrivecar") String testdrivecar) {
        String[] array = testdrivecar.split(" ");
        String model = array[1];


        Optional<TestDriveHuman> optionalHuman = testDriveHumanRepository.findById(id);
        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(model));

        optionalHuman.ifPresent(human -> {
            optionalCar.ifPresent(car->{
                if(!car.getMarkCar().equals("service")){
                    human.setMark("yes");
                    testDriveHumanRepository.save(human);

                    car.setMarkCar("yes");
                    carRepository.save(car);
                }
            });
        });

    }
    @PutMapping("/{id}/no")
    public void updateMarkNo(@PathVariable Long id,  @RequestParam("testdrivecar") String testdrivecar) {
        String[] array = testdrivecar.split(" ");
        String model = array[1];


        Optional<TestDriveHuman> optionalHuman = testDriveHumanRepository.findById(id);
        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(model));

        optionalHuman.ifPresent(human -> {
            optionalCar.ifPresent(car ->{
                if(car.getMarkCar().equals("service")){
                    human.setMark("no");
                    testDriveHumanRepository.save(human);
                }else{
                    human.setMark("no");
                    testDriveHumanRepository.save(human);
                    car.setMarkCar("no");
                    carRepository.save(car);
                }
            });
        });

//        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findByModel(model));
//        optionalCar.ifPresent(car -> {
//            car.setMarkCar("no");
//            carRepository.save(car);
//        });
    }


}
