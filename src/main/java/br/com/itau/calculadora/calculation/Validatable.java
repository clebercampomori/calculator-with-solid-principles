package br.com.itau.calculadora.calculation;

public interface Validatable<T> {

    boolean isValid(T number);
}
