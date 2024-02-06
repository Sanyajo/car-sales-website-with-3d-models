package diplom.demo.Repository.CarRepository;

import diplom.demo.models.carModels.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarInfoRepository  extends JpaRepository<CarInfo, Long> {
    @Query("SELECT c FROM CarInfo c WHERE c.model = :model AND c.seriestype = :seriestype")
    CarInfo findByModelAndSeriestype(String model, String seriestype);

//    @Query("SELECT c FROM CarInfo c WHERE c.model = :model AND c.seriestype = :seriestype")
//    CarInfo findCarUrlTitle(@Param("model") String model, @Param("seriestype") String seriestype);
}

