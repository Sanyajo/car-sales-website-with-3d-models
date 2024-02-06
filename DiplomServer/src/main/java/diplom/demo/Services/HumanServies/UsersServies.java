package diplom.demo.Services.HumanServies;


import diplom.demo.Repository.HumanRepository.UsersRepository;
import diplom.demo.models.HumanModels.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServies {

    private final UsersRepository usersRepository;

    public Users findUserForLogin(String userLogin){
        return usersRepository.findByUserLogin(userLogin);
    }
}
