package br.com.itau.calculadora;

import br.com.itau.calculadora.calculation.Sum;

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
        if (operation.equals("+")) {
            return new Sum().calculate(number1, number2);
        } else {
            return 0;
        }
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
