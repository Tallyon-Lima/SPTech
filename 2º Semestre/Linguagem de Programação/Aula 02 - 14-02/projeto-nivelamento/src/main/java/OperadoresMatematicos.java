import java.math.BigDecimal;

public class OperadoresMatematicos {
    public static void main(String[] args) {
        // No JS :
        // + - / * %
        // ++ --  += -=

        // No JAVA é a mesma coisa, menos a potencia ** , esse não tem no JAVA
        // BigDecimal é utilizado para mexer com dinheiro

        Double n1 = 42.0;
        Double n2 = 21.0;
        Double soma = n1 + n2;

        System.out.println("Soma: " + (n1 + n2));
        System.out.println("Multiplicação: " + (n1* n2));
        System.out.println("Subtração: " + (n1 - n2));
        System.out.println("Divisão: " + (n1 / n2));

        Double resultadoPotencia = Math.pow(n1, n2);
        System.out.println("Potência: " + resultadoPotencia);
        System.out.println("Teste Potência: " + Math.pow(n1, n2));

    }
}