//package swiss.pfadi.pfindusbackend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    //todo before prod activate auth
//        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
////        http.oauth2ResourceServer(Customizer.withDefaults());
//        return http.build();
//    }
//}
