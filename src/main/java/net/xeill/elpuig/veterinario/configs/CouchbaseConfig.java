package net.xeill.elpuig.veterinario.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import com.couchbase.client.core.env.SecurityConfig;
import com.couchbase.client.java.env.ClusterEnvironment;

@Configuration // Anotación para indicar que esta clase es una clase de configuración de Spring.
@EnableCouchbaseRepositories(basePackages = "net.xeill.elpuig.veterinario.repositories") // Habilita la búsqueda de repositorios Couchbase en el paquete especificado.
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    // Método para obtener la cadena de conexión de Couchbase
    @Override
    public String getConnectionString() {
        return System.getenv().getOrDefault("COUCHBASE_CONNECTION_STRING", "couchbase://localhost");
    }

    // Método para obtener el nombre de usuario para la conexión a Couchbase
    @Override
    public String getUserName() {
        return System.getenv().getOrDefault("COUCHBASE_USERNAME", "usuario");
    }

    // Método para obtener la contraseña para la conexión a Couchbase
    @Override
    public String getPassword() {
        return System.getenv().getOrDefault("COUCHBASE_PASSWORD", "usuario");
    }

    // Método para obtener el nombre del bucket en Couchbase
    @Override
    public String getBucketName() {
        return "veterinario"; // Nombre del bucket (base de datos) que se va a usar en Couchbase.
    }

    // Habilita TLS cuando la cadena de conexión usa el esquema seguro "couchbases://" (p. ej. Couchbase Capella).
    @Override
    protected void configureEnvironment(ClusterEnvironment.Builder builder) {
        if (getConnectionString().startsWith("couchbases://")) {
            builder.securityConfig(SecurityConfig.enableTls(true).enableCertificateVerification(true));
        }
    }

    // Definición del bean de CouchbaseTemplate
    @Bean
    public CouchbaseTemplate couchbaseTemplate() throws Exception {
        // Crea un objeto CouchbaseTemplate utilizando las configuraciones de conexión y conversión definidas en esta clase.
        return new CouchbaseTemplate(couchbaseClientFactory(null), mappingCouchbaseConverter(null, null), couchbaseTranslationService());
    }

    // Definición del bean de CouchbaseMappingContext
    @Bean
    public CouchbaseMappingContext couchbaseMappingContext() {
        // Crea y devuelve un nuevo contexto de mapeo de Couchbase.
        return new CouchbaseMappingContext();
    }
}
