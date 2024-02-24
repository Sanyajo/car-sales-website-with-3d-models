package diplom.demo.models.carModels;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private String series;

    @Column(name="urlimage")
    private String urlimage;

    @Column(name="motortype")
    private String motortype;

    @Column(name="seriestype")
    private String seriestype;

    @Column(name="mark")
    private String markCar;

    @Column(name="price")
    private String price;
}
