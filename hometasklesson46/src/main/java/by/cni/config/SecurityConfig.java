package by.cni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception{
        return http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(cust -> {
                    cust.loginPage("/login");
                    cust.loginProcessingUrl("/mylogin");
                    cust.usernameParameter("username");
                    cust.passwordParameter("password");
                    cust.successHandler((request, response, authentication) -> {
                        response.sendRedirect("/user");
                            });
                    cust.failureHandler((request, response, exception) -> {
                        response.sendRedirect("/registration");
                    });
                })
                .logout(cust -> {
                    cust.logoutUrl("/mylogout");
                    cust.logoutSuccessHandler((request, response, authentication) -> {
                        request.getSession().invalidate();
                        response.sendRedirect("/registration");
                    });
                })
                .authorizeHttpRequests(cust -> {
                    cust.requestMatchers("/registration", "/login").permitAll()
                            .requestMatchers("/user").hasRole("USER")
                            .requestMatchers("/admin").hasRole("ADMIN");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsManager userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

}
