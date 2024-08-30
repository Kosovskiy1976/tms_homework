package by.cni.config;

import by.cni.dto.ErrorDto;
import by.cni.esc.CommonServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder(){
        return ((s, response) -> {
            try (InputStream inputStream = response.body().asInputStream()){
                ObjectMapper objectMapper = new ObjectMapper();
                ErrorDto errorDto = objectMapper.readValue(inputStream, ErrorDto.class);
                return new CommonServiceException(errorDto.getCode(), errorDto.getMessage());
            } catch (Exception exc) {
                return new CommonServiceException(500, "unexpected error");
            }
        });
    }

}
