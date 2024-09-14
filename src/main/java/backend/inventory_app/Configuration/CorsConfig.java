package backend.inventory_app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173"); // Specific allowed origin
        config.addAllowedHeader("*"); // Allow all headers needed by the client
        config.addAllowedMethod("*");// Allow all HTTP methods needed by the client
        config.setExposedHeaders(List.of("Authorization", "Content-Type", "Accept")); // Specific headers to expose
        source.registerCorsConfiguration("/**", config); // Apply CORS to all paths
        return new CorsFilter(source);
    }
}

