package pl.sda.finalapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void registerUser(RegistrationUserDto dto) throws UserExistsExeption {

        //sprawzenie czy użytkownik istnieje
        Optional<User> byEmail = userRepository.findByEMail(dto.getEMail());
        if (byEmail.isPresent()) {
            throw new UserExistsExeption("Użytkownik o email " + byEmail.get().geteMail() + " już istnieje!");
        }
        //dodanie użytkownika do bazy
        User user = User.fromDto(dto, passwordEncoder.encode(dto.getPassword()));
        Role role = roleRepository.findByRoleName(Role.USER).orElseThrow(() -> new RuntimeException("Nie znaleziono roli!"));
        user.addRole(role);
        userRepository.save(user);
    }

}