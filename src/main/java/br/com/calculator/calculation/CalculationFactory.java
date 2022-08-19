package br.com.calculator.calculation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Temos uma "lógica" para criação de nossos cálculos: de acordo com a operação
// informada pelo usuário, nós retornamos uma instância diferente...
// Essa lógica não pode ficar "espalhada". Sendo assim, podemos usar
// um simple factory method para "centralizar" essa lógica :)
public class CalculationFactory {

    // Calculable é a abstração mais alta que faz sentido para nós,
    // já que no final, quem consome a calculadora está diretamente interessado em calcular.
    // Mesmo as operações com validação também são capazes de "calcular" e implementam
    // a interface Calculable.
    // Então, como sempre devemos nos orientar a abstração mais alta que faz sentido (Dependency Inversion Principle),
    // nós deixamos o nosso mapa como sendo de "Calculable". Então, qualquer operação,
    // fazendo validação ou não, pode ser colocada em nossa factory :)
    private Map<String, Calculable> operationMap;

    public CalculationFactory() {
        operationMap = new HashMap<>();
        operationMap.put("+", new Sum());
        operationMap.put("-", new Subtraction());
        operationMap.put("/", new Division());
        operationMap.put("*", new Multiplication());
    }

    // Um mapa, quando não encontra um objeto associado à chave, retorna null.
    // Métodos que retornam null podem causar NullPointerException em quem os invoca :(
    // Por isso, hoje temos o Optional, que nos permite "encapsular" um objeto e criar uma
    // abstração, para sabermos se ele foi definido ou não
    public Optional<Calculable> create(String operation) {
        return Optional.ofNullable(operationMap.get(operation));
    }
}
