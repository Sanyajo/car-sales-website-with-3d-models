package diplom.demo.models.carModels;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="carconfig")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;


    @Column(name="model")
    private String model;

    @Column(name="series")
    private String series;

    @Column(name="type")
    private String type;

    @Column(name="image")
    private String image;

    @Column(name="color")
    private String color;

    @Column(name="prefix")
    private String prefix;

    @Column(name="seriestype")
    private String seriestype;

}
