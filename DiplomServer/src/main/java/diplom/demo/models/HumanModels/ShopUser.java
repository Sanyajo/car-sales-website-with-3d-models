package diplom.demo.models.HumanModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopuser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="fullname")
    private String fullName;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="checkvalue")
    private String checkValue;

    @Column(name="car")
    private String car;
}
