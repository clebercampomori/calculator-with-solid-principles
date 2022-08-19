package br.com.calculator.calculation;

public abstract class CalculationWithValidation implements Calculable, Validatable<Integer> {

    // O cálculo é sempre feito com a mesma "receita": validamos o segundo número e,
    // se ele for válido, fazemos o cálculo. Caso contrário, arremessamos uma
    // exception. Então, o Template Method pode nos ajudar \o/
    // Ele é "final" para não deixar ninguém "mexer" em nossa "receita"
    @Override
    public final int calculate(int number1, int number2) {
        if (isValid(number2)) {
            return doCalculate(number1, number2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Mas a maneira como o cálculo é feito depende de cada operação...
    // Então, deixamos o método como abstrato, para forçar as implementações
    // a dizerem como cada cálculo deve ser de fato feito (soma, subtração, divisão etc.)
    protected abstract int doCalculate(int number1, int number2);

    // Aqui, temos a validação padrão para a maioria das operações
    // As operações que fazem a validação de maneira diferente, podem só sobrescrever
    // este método. A versão sobrescrita é a que será utilizada no template method
    // para as instâncias que sobrescreverem esse método :)
    @Override
    public boolean isValid(Integer input) {
        return input != 0;
    }
}
