package diplom.demo.Controller;

import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.Services.CarServies.CarServies;
import diplom.demo.Services.HumanServies.TestDriveHumanServies;
import diplom.demo.Services.HumanServies.UsersServies;
import diplom.demo.models.HumanModels.Users;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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


    @PostMapping("/addCarInputForm")
    public String addCarInputForm( @RequestParam("model") String model,
                                    @RequestParam("series") String series,
                                    @RequestParam("motortype") String motortype,
                                    @RequestParam("seriestype") String seriestype,
                                    @RequestParam MultipartFile photo) {
        if (photo.isEmpty()) {
//            return "Файл не был передан";
        }
        carServies.addCar(model, series, motortype, seriestype, photo);
        return "redirect:/globaladmin";
    }


    @GetMapping("/globaladmin")
    public String globalAdmin(Model modelAtr) {
        modelAtr.addAttribute("listCar", carServies.listCar());
        modelAtr.addAttribute("listHuman", testDriveHumanServies.allHuman());
        return "admin/globaladmin";
    }


}
