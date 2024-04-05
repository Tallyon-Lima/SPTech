import java.util.ArrayList;
import java.util.List;

public class RelatorioMetodos {

    void buscarQuantidadeVendas(List<Double> listaNumeros) {
        int i = 0;
        for (; i <= listaNumeros.size(); i++) {

        }
        System.out.println("A lista possui " + (i - 1));
    }

    void somarVendas(List<Double> listaNumeros) {
        Double valor = 0.0;
        for (int i = 0; i < listaNumeros.size(); i++) {
            valor += listaNumeros.get(i);
        }

        System.out.println("O valor total é: " + valor);
    }

    String buscarPreco(List<Double> listaNumeros, Double numeroPesquisado) {
        String boleano = "false";
        for (int i = 0; i < listaNumeros.size(); i++) {
            if(numeroPesquisado.equals(listaNumeros.get(i))) {
                boleano = "true";
            }
        }
        return ("O número pesquisado existe: " + boleano);
    }

    void buscarMaiorPreco(List <Double> listaNumeros){
        Double maior = 0.0;
        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) > maior){
                maior = listaNumeros.get(i);
            }
        }
        System.out.println("O maior número da lista é: " + maior);
    }

    void buscarMenorPreco(List <Double> listaNumeros){
        Double menor = listaNumeros.get(0);

        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) < menor){
                menor = listaNumeros.get(i);
            }
        }
        System.out.println("O menor número da lista é: " + menor);
    }



    void buscarPorPrecoMinimo(List <Double> listaNumeros, Double numeroPesquisado){
        List<Double> segundaLista = new ArrayList<>();

        for (int i = 0; i < listaNumeros.size(); i++) {

            if (listaNumeros.get(i) >= numeroPesquisado){
                segundaLista.add(listaNumeros.get(i));
            }
        }
        System.out.println("Números maiores ou iguais ao que você digitou");
        for (int i = 0; i < segundaLista.size(); i++) {
            System.out.println(segundaLista.get(i));
        }
    }

}
