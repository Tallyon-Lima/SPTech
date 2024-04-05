package empresa;

public class Empregado {
    private String nome;
    private String cargo;
    private Double salario;
    private Integer anosTrabalhados;
    private String promocao;
    private String novoCargo;

    public Empregado(String nome,
                     String cargo,
                     Double salario,
                     Integer anosTrabalhados,
                     String promocao,
                     String novoCargo) {

        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.anosTrabalhados = anosTrabalhados;
        this.promocao = promocao;
        this.novoCargo = novoCargo;
    }

    public Empregado() {
    }

    public Double reajustarSalario(Double porcentagem ){
        return salario+= salario * porcentagem;
    }

    public void atribuirDados(){
        nome = "João";
        salario = 5400.00;
        cargo = "Analista de Sistemas";
    }

    public void imprimirDados(){
        System.out.println("""
                O funcionario %s de cargo %s agora recebe %.2f como salário""".formatted(nome, cargo, salario));
    }

    public void verificarPromocao(){
        if (promocao.equals("Sim")){
              System.out.println((" O funcionario %s de antigo cargo %s que " +
               "agora recebe %.2f como salário, foi promovido para " +
                 "%s pois está a %d anos na empresa").formatted(nome, cargo
                    , salario, novoCargo,anosTrabalhados));
    }else {
            System.out.println("O funcionario %s teve o ajuste no salário," +
                    " porém, ele não foi promovido pois está pouco na empresa".formatted(
                            nome));
        }

    }


    public void setAnosTrabalhados(Integer anosTrabalhados){
        this.anosTrabalhados = anosTrabalhados;
    }

    public void setPromocao(String promocao){
        this.promocao = promocao;
    }

    public void setNovoCargo(String cargo) {
        this.novoCargo = cargo;
    }
}
