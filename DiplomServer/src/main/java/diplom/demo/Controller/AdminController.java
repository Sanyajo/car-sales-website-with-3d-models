package diplom.demo.Controller;

import diplom.demo.Services.CarServies.CarServies;
import diplom.demo.Services.CarServies.CarSliderServies;
import diplom.demo.Services.HumanServies.TestDriveHumanServies;
import diplom.demo.Services.HumanServies.UsersServies;
import diplom.demo.models.HumanModels.Users;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final TestDriveHumanServies testDriveHumanServies;
    private final UsersServies usersServies;
    private final CarServies carServies;
    private final CarSliderServies carSliderServies;


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("listHuman", testDriveHumanServies.allHuman());
        return "admin/admin";
    }

    @PostMapping("/admin")
    public String admin(@RequestParam("login") String login,
                        @RequestParam("password") String password) {

        Users users = usersServies.findUserForLogin(login);


        if (users.getUserLogin().equals(login) && BCrypt.checkpw(password, users.getUserPassword())) {
            return "redirect:/globaladmin";
        }
        return "redirect:/admin";
    }


    @PostMapping("/addCarInputForm")
    public String addCarInputForm( @RequestParam("model") String model,
                                    @RequestParam("series") String series,
                                    @RequestParam("motortype") String motortype,
                                    @RequestParam("seriestype") String seriestype,
                                    @RequestParam MultipartFile photo) {
        if (!photo.isEmpty() && !seriestype.isEmpty()) {
            carServies.addCar(model, series, motortype, seriestype, photo);
        }
        return "redirect:/globaladmin";
    }


    @PostMapping("/addcarsliderform")
    public String addCarSliderForm( @RequestParam("model") String model,
                                   @RequestParam("series") String series,
                                    @RequestParam MultipartFile image,
                                   @RequestParam("type") String type,
                                   @RequestParam("foldername") String folderName,
                                   @RequestParam("imageinfo") String imageinfo,
                                   @RequestParam("seriestype") String seriestype
                                  ) {
        if (!image.isEmpty() && !seriestype.isEmpty() && !type.isEmpty()) {
            carSliderServies.addCarSlider(model, series, image, type, folderName,  imageinfo, seriestype);
        }
        return "redirect:/globaladmin";
    }

    @PostMapping("/carDeleteForm")
    public String deleteCarDeleteForm(@RequestParam("carSelection") String carSelection){
        carServies.deleteCar(carSelection);
        return "redirect:/globaladmin";
    }

    @PostMapping("/carsliderdelete")
    public String carsliderdelete(@RequestParam("carid") Integer id){
        carSliderServies.deleteCarWriter(id);
        return "redirect:/globaladmin";
    }

    @GetMapping("/globaladmin")
    public String globalAdmin(Model modelAtr) {

        Set<String> carSliderTableName = carSliderServies.getTableColumnNames();

        modelAtr.addAttribute("carSliderTableNameList", carSliderTableName);
        modelAtr.addAttribute("listSlider", carSliderServies.allCarSlider());

        modelAtr.addAttribute("listDirct", carSliderServies.listDirectories("DiplomServer/src/main/resources/static/images/carslider"));

        modelAtr.addAttribute("listCar", carServies.listCar());
        modelAtr.addAttribute("listHuman", testDriveHumanServies.allHuman());

        return "admin/globaladmin";
    }


}
