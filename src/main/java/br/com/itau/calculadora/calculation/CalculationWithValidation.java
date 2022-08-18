package br.com.itau.calculadora.calculation;

public abstract class CalculationWithValidation implements Calculable, Validatable<Integer> {

    @Override
    public final int calculate(int number1, int number2) {
        if (isValid(number2)) {
            return doCalculate(number1, number2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    protected abstract int doCalculate(int number1, int number2);

    @Override
    public boolean isValid(Integer number) {
        return number != 0;
    }
}
