package by.cni.web;

import by.cni.dto.AuthRequestDto;
import by.cni.dto.AuthResponseDto;
import by.cni.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class HomeRestController {

    private final AuthService authService;

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto){
        return authService.auth(authRequestDto);
    }

    @PostMapping("/user")
    public String user(){
        return "This is user";
    }

    @PostMapping("/admin")
    public String admin(){
        return "This is admin";
    }
}
