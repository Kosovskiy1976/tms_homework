package by.cni.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(new Info()
                .title("Bike Rent Service")
                .description("This is a bike rent service"));
        return openAPI;
    }

    @Bean
    public GroupedOpenApi groupedSearchBike() {
        return GroupedOpenApi.builder()
                .group("search bike for id")
                .pathsToMatch("/rent/{id}")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedSearchBikes() {
        return GroupedOpenApi.builder()
                .group("search bikes for manufacturer")
                .pathsToMatch("/rent//all/{manufacturer}")
                .build();
    }
}
