import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Contato> contato;

    public Grupo(String nome) {
        this.nome = nome;
        this.contato = new ArrayList<>();
    }

    public Grupo() {
    }

    public void adicionar(Contato c){
        contato.add(c);
    }

    public void adicionar(List<Contato> novosContatos){
        contato.addAll(novosContatos);
    }

    public void remove(Contato c){
        for (int i = 0; i < contato.size(); i++) {
         Contato contatoDaVez = contato.get(i);
         if ((contatoDaVez.getNome().equals(c.getNome()))){
         contato.remove(i);
         }
        }
    }

    public void removerPeloNome(String nome){
        // AQUI ESTÁ ERRADO
        boolean existe = contato.contains(nome);
        contato.remove(existe);
    }

    public void exibirPorNome(String nome){

        for (Contato contatoDaVez : contato){
            if (contatoDaVez.getNome().equalsIgnoreCase(nome)){
                System.out.println("CHOREEEEIIIIIIIIIIIIIIIII");
                System.out.println(contatoDaVez);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(List<Contato> contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return """
                Nome do Grupo: %s
                Contatos do Grupo: %s""".formatted(nome, contato);
    }
}
