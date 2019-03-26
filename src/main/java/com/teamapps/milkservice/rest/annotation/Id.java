package com.teamapps.milkservice.rest.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = IdSerializer.class)
@JsonDeserialize(using = IdDeserializer.class)
@JacksonAnnotationsInside
public @interface Id {
}
