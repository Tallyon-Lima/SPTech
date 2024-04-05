public class Pet {
    private String nome;
    private Integer qtdIdasPetShop;
    private Double totalGasto;

    public Pet(String nome, Integer qtdIdasPetShop, Double totalGasto) {
        this.nome = nome;
        this.qtdIdasPetShop = qtdIdasPetShop;
        this.totalGasto = totalGasto;
    }

    public Pet() {
    }

    public String getNome() {
        return nome;
    }

    public void tomarBanho(Double valorBanho){
        qtdIdasPetShop++;
        totalGasto += valorBanho;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdIdasPetShop() {
        return qtdIdasPetShop;
    }

    public void setQtdIdasPetShop(Integer qtdIdasPetShop) {

        this.qtdIdasPetShop = qtdIdasPetShop;
    }

    public Double getTotalGasto(PetShop petShop) {
        totalGasto += qtdIdasPetShop * petShop.getValorBanho();
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }
}

