package diplom.demo.Controller;

import diplom.demo.Services.CarServies.CarServies;
import diplom.demo.Services.CarServies.CarSliderServies;
import diplom.demo.Services.HumanServies.ShopUserServies;
import diplom.demo.Services.HumanServies.TestDriveHumanServies;
import diplom.demo.Services.HumanServies.UsersServies;
import diplom.demo.models.HumanModels.Users;
import diplom.demo.models.carModels.CarSlider;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final TestDriveHumanServies testDriveHumanServies;
    private final UsersServies usersServies;
    private final CarServies carServies;
    private final CarSliderServies carSliderServies;
    private final ShopUserServies shopUserServies;


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
        return "/globaladmin";
    }

    @PostMapping("/editRecordId")
    public String editRecordId(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Object result = carSliderServies.editRecordId(id);
        redirectAttributes.addFlashAttribute("listEdit", result);
        return "redirect:/globaladmin";
    }

    @PostMapping("/updateRecord")
    public String updateRecord(@RequestParam("id") Integer id,
                               @RequestParam("model") String model,
                               @RequestParam("series") String series,
                               @RequestParam("image") String image,
                               @RequestParam("imageinfo") String imageinfo,
                               @RequestParam("type") String type,
                               @RequestParam("seriestype") String seriestype) {
       carSliderServies.updateRecord(id, model, series, image, imageinfo, type, seriestype);
        return "redirect:/globaladmin";
    }

    @PostMapping("/deleteRepFormTable")
    public String deleteRepFormTable(@RequestParam("repName") String repName){
        carSliderServies.deleteRep(repName);
        return "redirect:/globaladmin";
    }

    @GetMapping("/globaladmin")
    public String globalAdmin(Model modelAtr, @ModelAttribute("listEdit") Object listEdit) {

        Set<String> carSliderTableName = carSliderServies.getTableColumnNames();

        modelAtr.addAttribute("carSliderTableNameList", carSliderTableName);
        modelAtr.addAttribute("listSlider", carSliderServies.allCarSlider());

        modelAtr.addAttribute("listDirct", carSliderServies.listDirectories("DiplomServer/src/main/resources/static/images/carslider"));

        modelAtr.addAttribute("listCar", carServies.listCar());
        modelAtr.addAttribute("listHuman", testDriveHumanServies.allHuman());

        modelAtr.addAttribute("shopUsersList", shopUserServies.allShopUser());

        if (listEdit != null && listEdit.getClass().getDeclaredFields().length > 0) {
            modelAtr.addAttribute("listEdit", listEdit);
        }else {
            modelAtr.addAttribute("listEdit", carSliderServies.getFirstZagluhka());
        }

        return "admin/globaladmin";
    }


}
