package diplom.demo.models;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carinfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="fuelflow")
    private String fuelflow;

//    @Column(name="motortype")
//    private String motortype;

    @Column(name="carhistory")
    private String carhistory;

    @Column(name="cardesign")
    private String cardesign;

    @Column(name="series")
    private String series;

    @Column(name="pdfurl")
    private String pdfurl;

    @Column(name="videoreview")
    private String videoreview;

    @Column(name="seriestype")
    private String seriestype;

}
