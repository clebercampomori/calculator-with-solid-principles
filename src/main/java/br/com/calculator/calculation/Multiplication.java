package br.com.calculator.calculation;

public class Multiplication implements Calculable {

    @Override
    public int calculate(int number1, int number2) {
        return number1 * number2;
    }
}
