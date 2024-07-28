package com.mayer.java.functional;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
