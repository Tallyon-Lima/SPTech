package Desafio;

public class Loja {
    private String nomeLoja;
    private Integer qtdVendas;
    private Integer qtdMentaVendas;
    private Double valorTotalVendas;

    public Loja(String nomeLoja, Integer qtdMentaVendas) {
        this.nomeLoja = nomeLoja;
        this.qtdVendas = 0;
        this.qtdMentaVendas = qtdMentaVendas;
        this.valorTotalVendas = 0.0;
    }

    public Loja() {
        this.qtdVendas = 0;
        this.valorTotalVendas = 0.0;
    }

    public void realizarVenda(Double valorVenda){
        realizarVenda(valorVenda, 0.0);
    }

    public void realizarVenda(Double valorVenda, Double valorDesconto){
        this.qtdVendas++;
        this.valorTotalVendas += valorVenda -valorDesconto;
    }

    public Boolean verificarMeta(){
        Boolean atingiuMeta = false;
        if (qtdMentaVendas > qtdVendas){
            System.out.println("Você não bateu a meta!! Se esforce mais!!");
            return false;
        }else {
            System.out.println("Parabéns você atingiu a meta!!");
            return true;
        }
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Integer getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(Integer qtdVendas) {
        this.qtdVendas = qtdVendas;
    }

    public Integer getQtdMentaVendas() {
        return qtdMentaVendas;
    }

    public void setQtdMentaVendas(Integer qtdMentaVendas) {
        this.qtdMentaVendas = qtdMentaVendas;
    }

    public Double getValorTotalVendas() {
        return valorTotalVendas;
    }

    public void setValorTotalVendas(Double valorTotalVendas) {
        this.valorTotalVendas = valorTotalVendas;
    }

    @Override
    public String toString() {
        return """
                Nome da Loja: %s
                Quantidade De Venda: %d
                Quantidade Da Meta: %d
                Valor Total Da Venda: %.2f""".formatted(nomeLoja,
                qtdVendas, qtdMentaVendas, valorTotalVendas);
    }
}
