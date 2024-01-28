package diplom.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carimageurl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="titleImg")
    private String titleImg;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private String series;

}
