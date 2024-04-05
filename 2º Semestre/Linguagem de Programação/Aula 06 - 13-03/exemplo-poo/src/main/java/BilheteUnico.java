public class BilheteUnico {
    // Atributos = Caracteristicas

    String codigo;
    Double saldo;
    String nomeTitular;

    //Metodos = Comportamento
    void carregar(Double valor){
        if (valor <=0 ){
            System.out.println("Valor de recarga inválido");
        }else {
            saldo += valor;
            System.out.println("Recarga efetuada");
        }
    }

}
