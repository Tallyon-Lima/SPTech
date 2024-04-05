import java.util.ArrayList;
import java.util.List;

public class AdicionarMuitos {
    public static void main(String[] args) {

        Contato contato01 = new Contato("EU_TENTEEIIII");
        Contato contato02 = new Contato("teste");
        List<Contato> contatos = new ArrayList<>();
        contatos.addAll(List.of(contato01, contato02));
    }
}
