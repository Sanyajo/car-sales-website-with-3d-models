package diplom.demo.models.HumanModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="fio")
    private String userFIO;

    @Column(name="role")
    private String userRole;

    @Column(name="password")
    private String userPassword;

    @Column(name="login")
    private String userLogin;

}
