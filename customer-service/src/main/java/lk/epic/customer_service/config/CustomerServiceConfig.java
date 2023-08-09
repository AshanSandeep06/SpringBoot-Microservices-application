package lk.epic.customer_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerServiceConfig {
    @Bean
    @LoadBalanced
    // Using this @LoadBalanced annotation we can specify
    // that a request can either go to 1st instance or other instance
    // To load balance the requests
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
