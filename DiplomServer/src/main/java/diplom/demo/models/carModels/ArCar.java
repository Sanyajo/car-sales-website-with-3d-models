package diplom.demo.models.carModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arcar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private String series;

    @Column(name="qrurl")
    private String qrUrl;

    @Column(name="3durl")
    private String url3d;

    @Column(name="seriestype")
    private String seriestype;

    @Column(name="imageurl")
    private String imageUrl;
}
