package termometro;

public class Termometro {
    private Double temperaturaAtual;
    private Double temperaturaMax;
    private Double temperaturaMin;

    public Termometro(Double temperaturaAtual,
                      Double temperaturaMax,
                      Double temperaturaMin) {

        this.temperaturaAtual = temperaturaAtual;
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMin = temperaturaMin;
    }

    public Termometro() {
    }

    public void aumentarTemperatura(Double valor){
        temperaturaAtual += valor;

        if (temperaturaMax <= temperaturaAtual){
            temperaturaAtual = temperaturaMax;
        }
        System.out.println("Temperatura atual:" + temperaturaAtual);
    }

    public void diminuirTemperatura(Double valor){
        temperaturaAtual -= valor;

        if (temperaturaAtual <= temperaturaMin){
            temperaturaAtual = temperaturaMin;
        }
        System.out.println("Temperatura atual:" + temperaturaAtual);
    }

    public void getFahreinheit(){
        Double fahrenheit = (temperaturaAtual * 9/5) + 32;

        System.out.println("A atual na escala fahrenheit é: "+ fahrenheit);
    }

    public Double getTemperaturaAtual(Double temperaturaAtual) {
        return this.temperaturaAtual = temperaturaAtual;
    }

    public void setTemperaturaAtual(Double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    public Double getTemperaturaMax(Double temperaturaMax) {
        return this.temperaturaMax = temperaturaMax;
    }

    public void setTemperaturaMax(Double temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public Double getTemperaturaMin(Double temperaturaMin) {
        return this.temperaturaMin = temperaturaMin;
    }

    public void setTemperaturaMin(Double temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }
}
