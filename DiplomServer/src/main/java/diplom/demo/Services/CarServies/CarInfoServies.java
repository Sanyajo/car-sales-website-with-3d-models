package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarInfoRepository;
import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.models.carModels.Car;
import diplom.demo.models.carModels.CarInfo;
import diplom.demo.models.carModels.CarSlider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarInfoServies {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final CarInfoRepository carInfoRepository;
    private final CarRepository carRepository;

    public CarInfo listCarSeries(String model, String seriestype) {
        switch (seriestype) {
            case "M": {
                return carInfoRepository.findByModelAndSeriestype(model, seriestype);
            }
            case "stock": {
                return carInfoRepository.findByModelAndSeriestype(model, seriestype);
            }

            default:{
                return (CarInfo) Collections.emptyList();
            }
        }
    }

    public String getCarPDFUrl(String model, String series) throws IOException, DocumentException, URISyntaxException {
        String filePath = "DiplomServer/src/main/resources/static/pdf/CarPrice"+model+".pdf";
        File file = new File(filePath);
                file.createNewFile();
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                document.open();

                // Добавляем изображение
                Path path = Paths.get(ClassLoader.getSystemResource("static/images/main/pdfImage.jpeg").toURI());
                Image img = Image.getInstance(path.toAbsolutePath().toString());
                img.scaleAbsolute(600, 400); // Задаем размеры изображения
                img.setAlignment(Element.ALIGN_CENTER);
                document.add(img);

                // Добавляем пространство между изображением и таблицей
                document.add(new Paragraph(" "));

                // Добавляем таблицу
                PdfPTable table = new PdfPTable(3);
                addTableHeader(table);
                addCustomRows(table, model, series);

                document.add(table);
                document.close();

                return "/pdf/CarPrice"+model+".pdf";
    }

    public void addTableHeader(PdfPTable table) {
        Stream.of("Series", "Model", "Price")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });


    }

    private void addCustomRows(PdfPTable table, String model, String series)
            throws URISyntaxException, BadElementException, IOException {

        Car car = carRepository.findByModel(model);

        PdfPCell modelCell = new PdfPCell(new Phrase(car.getSeries().toString()));
        PdfPCell seriesCell = new PdfPCell(new Phrase(car.getModel().toString()));
        PdfPCell priceCell = new PdfPCell(new Phrase("300"));

        table.addCell(modelCell);
        table.addCell(seriesCell);
        table.addCell(priceCell);
    }

    public String getMotorType(String model, String seriestype) {
        String sql = "SELECT c.motortype " +
                "FROM car c " +
                "JOIN carinfo ci ON c.model = ci.model AND c.seriestype = ci.seriestype " +
                "WHERE c.model = ? AND ci.seriestype = ?";
        return jdbcTemplate.queryForObject(sql, String.class, model, seriestype);
    }

}
