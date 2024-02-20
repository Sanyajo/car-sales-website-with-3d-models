package diplom.demo.models.carModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pdftable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="url")
    private String pdfUrl;
}
