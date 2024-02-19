package diplom.demo.Controller;

import diplom.demo.Services.HumanServies.ShopUserServies;
import diplom.demo.models.carModels.CarInfo;
import diplom.demo.Services.CarServies.CarConfigServies;
import diplom.demo.Services.CarServies.CarInfoServies;
import diplom.demo.Services.CarServies.CarServies;
import diplom.demo.Services.CarServies.CarSliderServies;
import diplom.demo.Services.HumanServies.TestDriveHumanServies;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.charset.Charset;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarServies carServies;
    private final CarInfoServies carInfoServies;
    private final CarSliderServies carSliderServies;
    private final CarConfigServies carConfigServies;

    private final TestDriveHumanServies testDriveHumanServies;

    private final ShopUserServies shopUserServies;

    @GetMapping("/main")
    public String mainPage(Model model) {
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "main";
    }

    @GetMapping("/returnmain")
    public String returnmain(Model model) {
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "redirect:main";
    }

    @GetMapping("/future")
    public String future(Model model) {
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "mainRef/future";
    }

    @GetMapping("/oldcar")
    public String oldcar(Model model){
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "mainRef/oldcar";
    }

    @GetMapping("/testdrive")
    public String testdrive(Model model){
        model.addAttribute("listCar", carServies.listCar());
        return "mainRef/testdrive";
    }

    @GetMapping("/bmwinfo")
    public String bmwinfo(Model model) {
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "mainRef/bmwinfo/bmwinfo";
    }

    @PostMapping("/gettestdriveinfo")
    public String gettestdriveinfo(
            @RequestParam("fio") String fio,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("carSelection") String car,
            @RequestParam(value = "email", required = false) String email) {

        if(!fio.isEmpty()  && !phoneNumber.isEmpty()  && !car.isEmpty()){
            testDriveHumanServies.addHuman(fio, phoneNumber, car, email);
        }

        return "redirect:/gettestdriveinfo";
    }

    @GetMapping("/gettestdriveinfo")
    public String gettestdriveinfo(Model model) {
        model.addAttribute("listCar", carServies.listCar());
        return "mainRef/testdrive";
    }

    @GetMapping("/feedback")
    public String feedback(Model model){
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "mainRef/feedback";
    }


    @GetMapping("/allauto")
    public String shopauto(Model model){
        model.addAttribute("listAuto",carServies.listCar());
        fetchAndInjectHeaderHTML(model);
        fetchAndInjectFooterHTML(model);
        return "shopauto";
    }

    @PostMapping("/shopauto/{seriestype}/{series}/{model}")
    public String functt(@PathVariable String model,@PathVariable String series, @PathVariable String seriestype, Model modelAtr){
        CarInfo carInfo = carInfoServies.listCarSeries(model, seriestype);

        modelAtr.addAttribute("carInfo", carInfo);

        modelAtr.addAttribute("carSliderListBody", carSliderServies.listSliderImage(model, seriestype,"carbody"));
        modelAtr.addAttribute("carSliderListSalon", carSliderServies.listSliderImage(model, seriestype,"salon"));

        modelAtr.addAttribute("carConfigList",carConfigServies.listCarConfiog(model,seriestype,"body"));

        String motorType = carInfoServies.getMotorType(model, seriestype);
        modelAtr.addAttribute("motorType", motorType);

        modelAtr.addAttribute("car", carServies.getCar(model));

        fetchAndInjectHeaderHTML(modelAtr);
        fetchAndInjectFooterHTML(modelAtr);

        if(seriestype.equals("stock")){
            return "car/stockseries";
        }

        return "car/mseries";
    }


    @PostMapping("/price")
    public void pdfdownload(@PathVariable String model, @PathVariable String series, Model modelAtr){
        String pdfUrl = carInfoServies.getCarPDFUrl(model, series);
        modelAtr.addAttribute("pdfurl", pdfUrl);
    }

    @GetMapping("/shopuser")
    public String shopuser(Model model){
        model.addAttribute("listCar", carServies.listCar());
        return "mainRef/shopuser";
    }


    @PostMapping("/getshopuser")
    public String getshopuser(
            @RequestParam("fio") String fio,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("carSelection") String car,
            @RequestParam(value = "email", required = false) String email) {

        if(!fio.isEmpty()  && !phoneNumber.isEmpty()  && !car.isEmpty()){
            shopUserServies.addUserShop(fio, phoneNumber, car, email);
        }
        return "redirect:/getshopuser";
    }

    @GetMapping("/getshopuser")
    public String getshopuser(Model model) {
        model.addAttribute("listCar", carServies.listCar());
        return "mainRef/shopuser";
    }




    private void fetchAndInjectHeaderHTML(Model model) {
        try {
            // Загрузка ресурса из класспаса (src/main/resources)
            Resource resource = new ClassPathResource("templates/header.html");

            // Чтение содержимого файла в строку
            String htmlContent = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());

            // Добавление HTML-кода в модель
            model.addAttribute("htmlContentHeader", htmlContent);
        } catch (IOException e) {
            // Обработка ошибок, если не удается прочитать файл
            e.printStackTrace();
            model.addAttribute("htmlContentHeader", "<p>Error loading HTML(Header) content</p>");
        }
    }
    private void fetchAndInjectFooterHTML(Model model) {
        try {
            Resource resource = new ClassPathResource("templates/footer.html");
            String htmlContent = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
            model.addAttribute("htmlContentFooter", htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("htmlContentFooter", "<p>Error loading Html(Footer) content</p>");
        }
    }
}
