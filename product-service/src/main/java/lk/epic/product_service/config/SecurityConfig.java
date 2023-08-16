package lk.epic.product_service.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SecurityConfig {

}
//@EnableWebSecurity
/*public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity security) throws Exception {
        // In here we should say that all the incoming requests should be authenticated using the worlds2 login mechanism
        // Enable Spring security in product-service project
        security.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

    @PostConstruct
    // In this @PostConstruct, This will be executed right after the
    // Security conflict being is created
    // This method name means, That we are sharing the Security Context
    // also for the threads which are spawned by other processes
    // So with this method, Security Context holder should be also
    // available inside the threads which are spawned by resillence4j
    public void enableAuthenticationContextOnSpawnedThreads() {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
}*/
