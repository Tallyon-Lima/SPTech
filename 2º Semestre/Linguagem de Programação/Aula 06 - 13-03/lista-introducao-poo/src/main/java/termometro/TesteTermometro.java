package termometro;

import java.util.Scanner;

public class TesteTermometro {
    public static void main(String[] args) {
        Scanner inputNumero = new Scanner(System.in);
        Termometro termometro = new Termometro();

        System.out.println("Digite a temperatura atual");
        Double temperaturaAtual = inputNumero.nextDouble();
        termometro.getTemperaturaAtual(temperaturaAtual);

        System.out.println("Digite a temperatura maxima");
        Double temperaturaMax = inputNumero.nextDouble();
        termometro.getTemperaturaMax(temperaturaMax);

        System.out.println("Digite a temperatura minima");
        Double temperaturaMin = inputNumero.nextDouble();
        termometro.getTemperaturaMin(temperaturaMin);


while (true){
    System.out.println("""
            
            Escolha uma opção
            1- Aumentar a temperatura
            2- Diminuir a temperatura
            3- Exibir a temperatura em exibeFahreinheit 
            0- Encerrar o programa""");
    Integer opcao = inputNumero.nextInt();

    if (opcao.equals(1)){
        System.out.println("Digite o valor");
        Double valor = inputNumero.nextDouble();
        termometro.aumentarTemperatura(valor);
    }else if (opcao.equals(2)){
        System.out.println("Digite o valor");
        Double valor = inputNumero.nextDouble();
        termometro.diminuirTemperatura(valor);
    }else if (opcao.equals(0)){
        System.out.println("Programa Encerrado");
        break;
    }else if (opcao.equals(3)){
        termometro.getFahreinheit();
    }else {
        System.out.println("Opção invalida");
    }

}

    }
}
