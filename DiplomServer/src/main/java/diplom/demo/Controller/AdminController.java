package diplom.demo.Controller;

import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.Services.CarServies.CarServies;
import diplom.demo.Services.HumanServies.TestDriveHumanServies;
import diplom.demo.Services.HumanServies.UsersServies;
import diplom.demo.models.HumanModels.TestDriveHuman;
import diplom.demo.models.HumanModels.Users;
import diplom.demo.models.carModels.Car;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final TestDriveHumanServies testDriveHumanServies;
    private final UsersServies usersServies;
    private final CarServies carServies;

    private final CarRepository carRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("listHuman", testDriveHumanServies.allHuman());
        return "admin/admin";
    }

    @PostMapping("/admin")
    public String admin(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        Model modelAtr) {

        Users users = usersServies.findUserForLogin(login);


        if (users.getUserLogin().equals(login) && BCrypt.checkpw(password, users.getUserPassword())) {
            modelAtr.addAttribute("listCar", carServies.listCar());
            modelAtr.addAttribute("listHuman", testDriveHumanServies.allHuman());
            return "admin/globaladmin";
        }
        return "redirect:/admin";
    }


//    @GetMapping("/globaladmin")
//    public String globalAdmin(Model modelAtr) {
//        // Если данные для входа правильные, отображаем защищенную страницу
//        modelAtr.addAttribute("listHuman", testDriveHumanServies.allHuman());
//
//        return "admin/globaladmin";
//    }


}
