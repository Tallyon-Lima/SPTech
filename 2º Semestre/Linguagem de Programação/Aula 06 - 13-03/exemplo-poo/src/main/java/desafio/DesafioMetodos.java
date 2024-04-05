package desafio;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DesafioMetodos {
    Double meta;
    String proposito;
    String cofrinho;
    Double saldo;
    String status;

    Scanner inputDouble = new Scanner(System.in);

    void adicionarMetodo(){
        System.out.println("Digite o valor: ");
        Double addValor = inputDouble.nextDouble();

        if (status.equals("Quebrado")){
            System.out.println("O cofrinho já foi quebrado");
        }else {
            if (addValor < 0) {
                System.out.println("Valor incorreto");
            } else {
                saldo += addValor;
                System.out.println("O saldo do cofrinho é: " + saldo);
            }
            System.out.println(
                    ("Sua meta %.2f para seu objetivo de %s").formatted(meta, proposito));
        }
    }

    void agitarCofrinho(){
        if (status.equals("Quebrado")){
            System.out.println("O cofrinho já foi quebrado");
        }else if(saldo <= 0 ){
            System.out.println("Cofrinho vazio");
        }else {
            Double numeroAleatorio =
                    ThreadLocalRandom.current().nextDouble(0, saldo);
            saldo-= numeroAleatorio;
            System.out.println((
                    "O dinhero que saiu do cofrinho foi: %.2f"
                    ).formatted(numeroAleatorio));
        }
        System.out.println("Saldo final: %.2f".formatted(saldo));

    }


    void quebrarCofrinho(){
        if (status.equals("Quebrado")){
            System.out.println("O cofrinho já foi quebrado");
        }else{
            status = "Quebrado";

            System.out.println("""
                    O cofrinho foi quebrado
                    O cofrinho %s possuia %.2f""".formatted(cofrinho, saldo));
        }
    }



}
