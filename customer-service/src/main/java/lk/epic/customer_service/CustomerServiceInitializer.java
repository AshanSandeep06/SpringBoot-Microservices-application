package lk.epic.customer_service;

import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class CustomerServiceInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceInitializer.class, args);
    }

    /*@Bean
    public RequestInterceptor requestAccessTokenBearerInterceptor() {
        return (requestTemplate) -> {
            // Retrieve the Authentication Object from the Security Context
            JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            // Retrieve the jwt token from the Authentication Object and add that token into Authorization header
            requestTemplate.header("Authorization", "Bearer " + authentication.getToken().getTokenValue());
            System.out.println("Bearer Token........!");
        };
    }*/

   /* @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return requestTemplate -> {
            JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext()
                    .getAuthentication();

            requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
        };
    }*/
}
