public class Contato {
    private String nome;
    private String telefone;
    private Boolean bloquado;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.bloquado = false;
    }

    public Contato(String nome) {
        this.nome = nome;
    }

    public Contato() {

    }

    public void bloquear(){
        this.bloquado= true;
    }
    public void desbloquear(){
        this.bloquado= false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getBloquado() {
        return bloquado;
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Telefone: %s
                Bloqueado: %s""".formatted(nome, telefone, ( bloquado ? "Sim" : "Não"));
    }
}
