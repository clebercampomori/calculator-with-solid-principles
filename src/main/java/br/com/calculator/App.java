package br.com.calculator;

import br.com.calculator.calculation.Calculable;
import br.com.calculator.calculation.CalculationFactory;

import java.util.Optional;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String operation = readString("Digite a operação desejada: ");
        int number1 = readNumber("Digite o primeiro número: ");
        int number2 = readNumber("Digite o segundo número: ");
        int result = calculate(number1, number2, operation);
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static int calculate(int number1, int number2, String operation) {
        // Tenho um "Calculable" porque toda operação "faz" um cálculo
        // E, aqui em nossa aplicação, eu me interesso diretamente é pelo cálculo em si :)
        // Mas ele é um Optional porque o usuário pode informar uma operação inválida
        Optional<Calculable> calculation = new CalculationFactory().create(operation);
        // Agora, vejo se meu Optional foi preenchido com uma instância ou não
        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            // Se tem uma instância lá dentro, basta para nós chamarmos o método "calculate()" \o/
            return calculation.get().calculate(number1, number2);
        }
//        Também poderia ser dessa maneira, encadeando as chamadas e usando mais recursos do Optional
//        Nesse caso, utilizaríamos uma lambda para informar qual exceção gostaríamos que fosse
//        arremessada caso o Optional fosse vazio
//        Optional<Calculable> calculation = new CalculationFactory().create(operation);
//        calculation.orElseThrow(() -> new IllegalArgumentException()).calculate(number1, number2);
//        Também podemos fazer dessa maneira, com "method reference":
//        Optional<Calculable> calculation = new CalculationFactory().create(operation);
//        calculation.orElseThrow(IllegalArgumentException::new).calculate(number1, number2);
    }

    private static int readNumber(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }

    private static String readString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}
