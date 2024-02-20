package diplom.demo.Repository.PdfRepository;

import diplom.demo.models.carModels.PdfModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfRepository extends JpaRepository<PdfModel, Long> {
    PdfModel findByModel(String model);
}
