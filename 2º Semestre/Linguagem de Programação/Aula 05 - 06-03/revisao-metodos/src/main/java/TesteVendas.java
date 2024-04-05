import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteVendas {
    public static void main(String[] args) {

        RelatorioMetodos metodosRelatorio = new RelatorioMetodos();
        Scanner input = new Scanner(System.in);

        List <Double> listaNumeros = new ArrayList<>();
        listaNumeros.add(10.23);
        listaNumeros.add(23.2);
        listaNumeros.add(38.40);
        listaNumeros.add(40.32);
        listaNumeros.add(59.0);
        listaNumeros.add(61.01);
        listaNumeros.add(7.21);
        listaNumeros.add(8.2);
        listaNumeros.add(9.30);
        listaNumeros.add(2.1);

        metodosRelatorio.buscarQuantidadeVendas(listaNumeros);

        metodosRelatorio.somarVendas(listaNumeros);

        System.out.println("Digite um número para pesquisa");
        Double numeroPesquisado = input.nextDouble();
        System.out.println(metodosRelatorio.buscarPreco(listaNumeros, numeroPesquisado));

        metodosRelatorio.buscarMaiorPreco(listaNumeros);

        metodosRelatorio.buscarMenorPreco(listaNumeros);

        System.out.println("Digite um número para o filtro");
        numeroPesquisado = input.nextDouble();
        metodosRelatorio.buscarPorPrecoMinimo(listaNumeros, numeroPesquisado);
    }
}
