import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Teste {

    public static void main(String[] args) {
        //Exemplo método não é uma variável e sim um objeto
        // Para criar objeto utilizado o new
        //Instância = criar um objeto
        ExemploMetodo exemploMetodo = new ExemploMetodo();

        exemploMetodo.apresentarUsuario("Tallyon", "Lima");

        Double valorTaxa =exemploMetodo.calcularTaxa(1005.00);
        System.out.println(valorTaxa);

        List<String> nomes = new ArrayList<>();
        nomes.add("Bob");
        nomes.add("Caramelo");
        nomes.add("Tallyon");
        exemploMetodo.exibirNomes(nomes);

    }
}
