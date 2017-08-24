package com.random.test;

import java.lang.annotation.*;

/**
 * Created by prajeeva on 8/19/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface VariableAnnotations {
    VariableAnnotation[] value();
}
