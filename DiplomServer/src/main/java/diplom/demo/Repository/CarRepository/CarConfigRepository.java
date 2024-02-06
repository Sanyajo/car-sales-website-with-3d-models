package diplom.demo.Repository.CarRepository;

import diplom.demo.models.carModels.CarConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarConfigRepository extends JpaRepository<CarConfig, Long> {

    @Query("SELECT c FROM CarConfig c WHERE c.model = :model AND c.series = :series AND c.type = :type")
    List<CarConfig> findByModelAndSeriesAndTypeList(String model, String series, String type);

//    CarConfig findByModelAndSeriesAndType(String model, String series, String type);

}
