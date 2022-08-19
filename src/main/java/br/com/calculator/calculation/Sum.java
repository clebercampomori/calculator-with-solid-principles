package br.com.calculator.calculation;


public class Sum extends CalculationWithValidation {

    @Override
    protected int doCalculate(int number1, int number2) {
        return number1 + number2;
    }
}
