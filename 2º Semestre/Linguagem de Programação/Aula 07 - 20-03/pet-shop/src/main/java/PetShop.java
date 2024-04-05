public class PetShop {
    private String nome;
    private Double faturamentoTotal;
    private Double valorBanho;

    public PetShop(String nome, Double faturamentoTotal) {
        this.nome = nome;
        this.faturamentoTotal = faturamentoTotal;
        valorBanho = 40.0;
    }
    public PetShop() {
    }

    public void darBanho(Pet pet){
        darBanho(pet, 0.0);
    }

    public void darBanho(Pet pet, Double desconto){
        Double valorComDesconto = (this.valorBanho -
                (this.valorBanho * desconto));
        faturamentoTotal += valorBanho;
        pet.tomarBanho(valorComDesconto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getFaturamentoTotal() {
        return faturamentoTotal;
    }

    public void setFaturamentoTotal(Double faturamentoTotal) {
        this.faturamentoTotal = faturamentoTotal;
    }

    public Double getValorBanho() {
        return valorBanho;
    }

    public void setValorBanho(Double valorBanho) {
        this.valorBanho = valorBanho;
    }
}
