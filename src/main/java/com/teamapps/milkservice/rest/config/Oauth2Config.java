package com.teamapps.milkservice.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Mihai Alexandru
 * @date 25.12.2018
 */
@Configuration
@EnableResourceServer
public class Oauth2Config extends ResourceServerConfigurerAdapter {

    @Autowired
    private OauthProperties oauthProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                cors()
                .configurationSource(configurationSource())
                .and()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .access("#oauth2.hasScope('" + oauthProperties.getScope() + "')");

    }

    @Bean
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Primary
    @Bean
    public RemoteTokenServices tokenService(OauthProperties oauthProperties) {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(oauthProperties.getCheckTokenUrl());
        tokenService.setClientId(oauthProperties.getClientId());
        tokenService.setClientSecret(oauthProperties.getClientSecret());
        return tokenService;
    }


}
