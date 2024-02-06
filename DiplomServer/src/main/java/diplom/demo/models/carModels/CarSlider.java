package diplom.demo.models.carModels;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="slidertable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSlider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private String series;

    @Column(name="image")
    private String imageSlider;

    @Column(name="imageinfo")
    private String imageinfo;

    @Column(name="type")
    private String type;

    @Column(name="seriestype")
    private String seriestype;
}
