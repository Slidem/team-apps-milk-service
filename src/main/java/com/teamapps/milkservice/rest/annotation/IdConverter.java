package com.teamapps.milkservice.rest.annotation;


import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class IdConverter implements Converter<String, Integer>, ConditionalConverter {

    @Override
    public Integer convert(String s) {
        return IdEncodingUtil.decode(s);
    }

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return targetType.hasAnnotation(Id.class);
    }
}
