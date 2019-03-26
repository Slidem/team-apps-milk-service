package com.teamapps.milkservice.rest.config;

import com.teamapps.milkservice.rest.annotation.IdConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
@Configuration
public class MilkServiceWebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new IdConverter());
    }

}
