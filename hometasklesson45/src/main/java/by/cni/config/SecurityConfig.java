package by.cni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception{
       return http.authorizeHttpRequests(cust -> {
            cust.requestMatchers("/home").permitAll()
                    .requestMatchers("/task").hasAuthority("task")
                    .requestMatchers("/order").hasRole("custom");
        })
               .httpBasic(Customizer.withDefaults())
               .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        var encoder = new BCryptPasswordEncoder();

        UserDetails user1 = User.withUsername("aaa").password(encoder.encode("qwerty"))
                        .authorities("task").build();
        UserDetails user2 = User.withUsername("bbb").password(encoder.encode("qwerty"))
                        .roles("custom").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
