package diplom.demo.models.HumanModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "testdrivehuman")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDriveHuman {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="fullname")
    private String FullName;

    @Column(name="telephonenumber")
    private String telephoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="mark")
    private String mark;

    @Column(name="car")
    private String testDriveCar;


}
