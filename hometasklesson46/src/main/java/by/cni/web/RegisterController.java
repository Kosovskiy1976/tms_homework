package by.cni.web;

import by.cni.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegisterController {

    private final UserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String register(){
        return "registration";
    }

    @PostMapping
    public String register(PersonDto personDto){
        String password = personDto.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        personDto.setPassword(encodePassword);
        jdbcUserDetailsManager.createUser(personDto);
        return "redirect:/registration";
    }
}
