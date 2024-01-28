package diplom.demo.Repository;

import diplom.demo.models.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarInfoRepository  extends JpaRepository<CarInfo, Long> {
    @Query("SELECT c FROM CarInfo c WHERE c.model = :model AND c.series = :series")
    CarInfo findByModelAndSeries(String model, String series);
}

