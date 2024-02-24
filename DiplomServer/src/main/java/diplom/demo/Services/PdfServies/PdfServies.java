package diplom.demo.Services.PdfServies;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import diplom.demo.Repository.CarRepository.CarRepository;
import diplom.demo.Repository.PdfRepository.PdfRepository;
import diplom.demo.models.carModels.Car;
import diplom.demo.models.carModels.PdfModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class PdfServies {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final PdfRepository pdfRepository;
    private final CarRepository carRepository;

    public String getPdfUrl(String model) throws DocumentException, IOException, URISyntaxException {

        boolean check = true;
        if(pdfRepository.findByModel(model) != null){
            getCarPDFUrl(model, check);
        }else{
            check = false;
            getCarPDFUrl(model,check);
        }

        return pdfRepository.findByModel(model).getPdfUrl();

    }

    public void getCarPDFUrl(String model, Boolean check) throws IOException, DocumentException, URISyntaxException {
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
        addCustomRows(table, model);

        document.add(table);
        document.close();

        String url = "/pdf/CarPrice"+model+".pdf";
        String sql = "";

        if(check){
            sql = "UPDATE pdftable SET url = :url WHERE model = :model";

        }else{
            sql = "INSERT INTO pdftable (url, model) VALUES (:url, :model)";
        }

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("url", url);
        parameters.addValue("model", model);

        try {
            namedParameterJdbcTemplate.update(sql, parameters);
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении вставки записи в базу данных: " + e.getMessage());
        }

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

    private void addCustomRows(PdfPTable table, String model)
            throws URISyntaxException, BadElementException, IOException {

        Car car = carRepository.findByModel(model);

        PdfPCell modelCell = new PdfPCell(new Phrase(car.getSeries().toString()));
        PdfPCell seriesCell = new PdfPCell(new Phrase(car.getModel().toString()));
        PdfPCell priceCell = new PdfPCell(new Phrase(car.getPrice().toString()));

        table.addCell(modelCell);
        table.addCell(seriesCell);
        table.addCell(priceCell);
    }
}
