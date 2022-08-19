package br.com.calculator.calculation;

public class Subtraction extends CalculationWithValidation {

    @Override
    protected int doCalculate(int number1, int number2) {
        return number1 - number2;
    }

    // A subtração também precisa de validação, mas não da mesma maneira que em CalculationWithValidation
    // Não tem problema: podemos sobrescrever a validação nas operações que fazem isso
    // de maneira diferente :)
    @Override
    public boolean isValid(Integer input) {
        return input > 0;
    }
}
