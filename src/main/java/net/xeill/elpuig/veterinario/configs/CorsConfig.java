package net.xeill.elpuig.veterinario.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Indica que esta clase es una clase de configuración de Spring
public class CorsConfig {

    // Define un bean que proporciona configuración para CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        // Orígenes permitidos configurables vía variable de entorno (lista separada por comas).
        // Por defecto "*" para no romper el uso en local.
        String[] allowedOrigins = System.getenv()
                .getOrDefault("CORS_ALLOWED_ORIGINS", "*")
                .split(",");

        return new WebMvcConfigurer() {
            // Sobrescribe el método addCorsMappings para configurar los permisos de CORS
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite solicitudes CORS en todas las rutas (/**)
                        .allowedOrigins(allowedOrigins) // Orígenes permitidos (p. ej. tu dominio de Netlify en producción)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite estos métodos HTTP para solicitudes CORS
                        .allowedHeaders("*"); // Permite todos los encabezados en las solicitudes CORS
            }
        };
    }
}
