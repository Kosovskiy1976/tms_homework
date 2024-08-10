package by.cni.services;

import by.cni.dto.AuthRequestDto;
import by.cni.dto.AuthResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    public AuthResponseDto auth(AuthRequestDto requestDto){
        UserDetails userDetails = manager.loadUserByUsername(requestDto.getUsername());

        if (!encoder.matches(requestDto.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException();
        }

        String token = tokenService.createToken(userDetails);

        return new AuthResponseDto(token);
    }
}
