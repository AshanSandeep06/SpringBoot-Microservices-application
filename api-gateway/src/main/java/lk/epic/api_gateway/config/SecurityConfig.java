package lk.epic.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {
    // In this class, we have to define a bean to create spring security filter chain
    // Me bean eka dana eken mean krnne, that all the incoming requests,
    // should be authenticated by our oauth2 provider
    /*@Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
                .oauth2Login(withDefaults());
        http.csrf().disable();
        return http.build();
    }*/
}
