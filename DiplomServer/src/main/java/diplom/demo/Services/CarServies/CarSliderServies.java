package diplom.demo.Services.CarServies;

import diplom.demo.Repository.CarRepository.CarSliderRepository;
import diplom.demo.models.carModels.CarSlider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarSliderServies {
    private final CarSliderRepository carSliderRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CarSlider> listSliderImage(String model, String seriestype, String type){
        return carSliderRepository.findByModelAndSeriestypeAndType(model, seriestype, type);
    }

    public Set<String> getTableColumnNames() {
        String sql = "SELECT * FROM slidertable";
        Set<String> columnNamesSet = new HashSet<>();

        jdbcTemplate.query(sql, rs -> {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnNamesSet.add(columnName);
            }
        });

        return columnNamesSet;
    }

    public List<CarSlider> allCarSlider(){
        return carSliderRepository.findAll();
    }

    public String addCarSlider(String model, String  series, MultipartFile image, String type, String folderName, String imageinfo, String seriestype){
        String sql = "INSERT INTO slidertable (model, series, image, type, imageinfo, seriestype) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            String directoryPath = "DiplomServer/src/main/resources/static/images/carslider/" + folderName;
            createDirectoryIfNotExists(directoryPath);


            Path directory = Paths.get("DiplomServer/src/main/resources/static/images/carslider/" + folderName);
            Path filePath = directory.resolve(image.getOriginalFilename());

            Files.write(filePath, image.getBytes());

            String urlImageStr = "/images/carslider/"+ folderName+ "/" + image.getOriginalFilename();

            jdbcTemplate.update(sql, model, series, urlImageStr, type, imageinfo, seriestype);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Car added successfully";
    }

    public boolean deleteCarWriter(Integer id){
        String sql = "DELETE FROM slidertable WHERE id=?";
        try{
            int check = jdbcTemplate.update(sql, id);
            if(check > 0){
                return true;
            }else{
                return false;
            }
        }catch (DataAccessException e){
            log.error("Не удалилась запись с иаким id", id, e);
            return false;
        }
    }
    public  void createDirectoryIfNotExists(String directoryPath) {
        Path directory = Paths.get(directoryPath);
        if (!Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
                System.out.println("Директория создана: " + directory);
            } catch (IOException e) {
                System.err.println("Не удалось создать директорию: " + directory);
                e.printStackTrace();
            }
        } else {
            System.out.println("Директория уже существует: " + directory);
        }
    }

    public List<String> listDirectories(String directoryPath) {
        List<String> stringList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    stringList.add(String.valueOf(entry.getFileName()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public String deleteRep(String repName){
       File file = new File("DiplomServer/src/main/resources/static/images/carslider/"+repName);
       if(!file.delete()){
           System.out.println("Директория НЕ удалена !");
       }

       return "Директория удалена";
    }
}
