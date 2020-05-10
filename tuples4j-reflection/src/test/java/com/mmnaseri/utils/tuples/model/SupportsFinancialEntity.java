package com.mmnaseri.utils.tuples.model;

import com.mmnaseri.utils.tuples.annotations.WithHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WithHandler(FinancialEntityHandler.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SupportsFinancialEntity {}
