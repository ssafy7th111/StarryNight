package starrynight.config.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity)http.csrf().disable()).cors().configurationSource(this.corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("http://localhost:3000");
        configuration.addAllowedOriginPattern("http://localhost:8081");
//        configuration.addAllowedOriginPattern("http://j7a605.p.ssafy.io:8081");
//        configuration.addAllowedOriginPattern("https://j7a605.p.ssafy.io:8081");
//        configuration.addAllowedOriginPattern("http://j7a605.p.ssafy.io:3000");
//        configuration.addAllowedOriginPattern("https://j7a605.p.ssafy.io:3000");
//        configuration.addAllowedOriginPattern("https://j7a605.p.ssafy.io");
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public SecurityConfig() {
    }
}
