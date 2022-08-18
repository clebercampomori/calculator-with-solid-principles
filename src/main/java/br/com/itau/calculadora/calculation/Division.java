package br.com.itau.calculadora.calculation;

public class Division extends CalculationWithValidation {

    @Override
    protected int doCalculate(int number1, int number2) {
        return number1 / number2;
    }
}

