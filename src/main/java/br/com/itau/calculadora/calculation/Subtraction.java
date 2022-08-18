package br.com.itau.calculadora.calculation;

public class Subtraction extends CalculationWithValidation {

    @Override
    protected int doCalculate(int number1, int number2) {
        return number1 - number2;
    }

    @Override
    public boolean isValid(Integer number) {
        return number > 0;
    }
}
