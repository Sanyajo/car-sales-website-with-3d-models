package diplom.demo.Repository;

import diplom.demo.models.CarImageUrl;
import diplom.demo.models.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CarImageRepository extends JpaRepository<CarImageUrl, Long>{

    @Query("SELECT c FROM CarImageUrl c WHERE c.model = :model AND c.series = :series")
    CarImageUrl findCarUrlTitle(@Param("model") String model, @Param("series") String series);
}
