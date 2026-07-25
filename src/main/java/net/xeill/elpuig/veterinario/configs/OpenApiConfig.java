package net.xeill.elpuig.veterinario.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Anotación para indicar que esta clase es una clase de configuración de Spring.
public class OpenApiConfig {

    // Define los metadatos (título, descripción, versión) que se muestran en Swagger UI.
    @Bean
    public OpenAPI veterinarioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Veterinario API")
                        .description("API REST para la gestión de una clínica veterinaria: usuarios, mascotas y tratamientos.")
                        .version("v1"));
    }
}
