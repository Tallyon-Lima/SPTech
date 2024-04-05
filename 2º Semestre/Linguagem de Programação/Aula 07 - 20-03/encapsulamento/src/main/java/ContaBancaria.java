public class ContaBancaria {
    private String nomeTitular;
    private Double saldo;
    private String numeroConta;
    private Integer numeroAgencia;

    //Regras contrutor:
    // Sempre public
    // Tem o mesmo nome da classe


    public ContaBancaria(String nomeTitular,
                         String numeroConta,
                         Integer numeroAgencia) {
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
    }

    public ContaBancaria() {

    }

    public void sacar(Double valorSaque){
       if (valorSaque.equals(null) || valorSaque<= 0 || valorSaque > saldo){
           System.out.println("Valor do saque inválido");
       }else {
           saldo-= valorSaque;
           System.out.println(nomeTitular + " saldo realizado! /n Saldo atual " + saldo);
       }
    }

    public void depositar(Double valorDeposito){
        if (valorDeposito <= 0 || valorDeposito.equals(null)) {
            System.out.println("Valor inválido");
        }else{
            saldo+=  valorDeposito;
            System.out.println(nomeTitular + "saldo realizado! /n Saldo atual " + saldo);
        }
    }

    //This indica o atributo obrigatorio quando recebemos argumentos com o mesmo nome

    // Padrão GET & SET
    // get = buscar
    // set = alterar
    public void setNomeTitular(String nomeTitular){this.nomeTitular = nomeTitular;}

    public  String getNomeTitular(){
        return this.nomeTitular;
    }

}
