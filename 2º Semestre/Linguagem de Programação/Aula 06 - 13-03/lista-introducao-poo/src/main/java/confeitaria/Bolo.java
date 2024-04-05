package confeitaria;

public class Bolo {
    private String sabor;
    private Double valor;
    private Integer qtdVendida;

    public Bolo(String sabor, Double valor, Integer qtdVendida) {
        this.sabor = sabor;
        this.valor = valor;
        this.qtdVendida = qtdVendida;
    }

    public void comprarBolo(Integer qtdVendida){
        if (this.qtdVendida > 100){
            System.out.println("""
                    Seu pedido ultrapasso nosso limite diário para esse bolo.""");

        }else{
            this.qtdVendida += qtdVendida;
        }
    }

    public void getRelatorio(){
        Double totalVendido = valor * qtdVendida;
        System.out.println("O bolo sabor %s, foi comprado %d vezes hoje, totalizando R$ %.2f".formatted(sabor, qtdVendida,totalVendido));
    }



}
