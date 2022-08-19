package br.com.calculator.calculation;

public interface Validatable<T> {

    boolean isValid(T input);
}
