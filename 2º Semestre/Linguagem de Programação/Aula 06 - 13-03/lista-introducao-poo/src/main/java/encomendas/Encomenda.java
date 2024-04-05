package encomendas;

public class Encomenda {
    private String tamanho;
    private String enderecoRemetente;
    private String enderecoDestinatario;
    private Double distancia;
    private Double valorEncomenda;
    private Double frete = 0.0 ;

    public Encomenda(String tamanho,
                     String enderecoRemetente,
                     String enderecoDestinatario,
                     Double distancia,
                     Double valorEncomenda,
                     Double frete) {

        this.tamanho = tamanho;
        this.enderecoRemetente = enderecoRemetente;
        this.enderecoDestinatario = enderecoDestinatario;
        this.distancia = distancia;
        this.valorEncomenda = valorEncomenda;
        this.frete = frete;
    }

    public Encomenda() {
    }

    public void calcularFrete(){
        if (tamanho.equals("P")){
            frete += valorEncomenda * 0.01;
        }else if (tamanho.equals("M")){
            frete += valorEncomenda * 0.03;
        }else{
            frete += valorEncomenda * 0.05;
        }

        if (distancia <= 50){
            frete += 3;
        } else if (distancia <= 200) {
            frete += 5;
        }else {
            frete += 7;
        }
    }

    public void getEtiqueta(){
        System.out.println("""
                
                ***** ETIQUETA PARA ENVIO *****
                Endereço do remetente: %s
                Endereço do destinatário: %s
                Tamanho: %s
                --------------------------------------------------
                Valor encomenda: R$ %.2f
                Valor frete: R$ %.2f
                --------------------------------------------------
                Valor total: R$ %.2f
                """.formatted(enderecoRemetente, enderecoDestinatario, tamanho,
                valorEncomenda, frete, (valorEncomenda + frete)));
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getEnderecoRemetente() {
        return enderecoRemetente;
    }

    public void setEnderecoRemetente(String enderecoRemetente) {
        this.enderecoRemetente = enderecoRemetente;
    }

    public String getEnderecoDestinatario() {
        return enderecoDestinatario;
    }

    public void setEnderecoDestinatario(String enderecoDestinatario) {
        this.enderecoDestinatario = enderecoDestinatario;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getValorEncomenda() {
        return valorEncomenda;
    }

    public void setValorEncomenda(Double valorEncomenda) {
        this.valorEncomenda = valorEncomenda;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }
}
