package desafio;

import java.util.Scanner;

public class DesafioMain {
    public static void main(String[] args) {

        Scanner inputInteger = new Scanner(System.in);
        Scanner inputLine = new Scanner(System.in);


        DesafioMetodos metodosDesafio = new DesafioMetodos();

        DesafioMetodos cofrinho01 = new DesafioMetodos();
        cofrinho01.meta  = 3500.00;
        cofrinho01.proposito = "Aquisição de uma bicicleta nova";
        cofrinho01.saldo = 20.0;
        cofrinho01.status = "Inteiro";
        cofrinho01.cofrinho = "C001";

        DesafioMetodos cofrinho02 = new DesafioMetodos();
        cofrinho02.meta  = 1800.00;
        cofrinho02.proposito = "Aquisição de um Playstation 5";
        cofrinho02.saldo = 10.0;
        cofrinho02.status = "Inteiro";
        cofrinho02.cofrinho = "C002";


        while (true) {
            System.out.println("""
                Escolha a opção que você deseja
                1- Adicionar dinheiro no cofrinho
                2- Agitar Cofrinho
                3- Quebrar Cofrinho
                0- Encerrar Programa
                Digite o numero da opção desejada""");
            Integer opcao = inputInteger.nextInt();

            if (opcao.equals(0)) {
                System.out.println("Programa Encerrado");
                break;
            }else{
                if(opcao.equals(1)){
                    System.out.println("Digite o cofrinho que deseja adicionar");
                    String cofrinhoDesejado = inputLine.nextLine();

                    if (cofrinhoDesejado.equals(cofrinho01.cofrinho)){
                        cofrinho01.adicionarMetodo();
                    }else if (cofrinhoDesejado.equals(cofrinho02.cofrinho)){
                        cofrinho02.adicionarMetodo();
                    }else {
                        System.out.println("Cofrinho não existe");
                    }
                }else if (opcao.equals(2)){
                    System.out.println("Digite o cofrinho que deseja adicionar");
                    String cofrinhoDesejado = inputLine.nextLine();

                    if (cofrinhoDesejado.equals(cofrinho01.cofrinho)){
                        cofrinho01.agitarCofrinho();
                    }else if (cofrinhoDesejado.equals(cofrinho02.cofrinho)){
                        cofrinho02.adicionarMetodo();
                    }else {
                        System.out.println("Cofrinho não existe");
                    }

                }else if (opcao.equals(3)){
                    System.out.println("Digite o cofrinho que deseja alterar: ");
                    String cofrinhoDesejado = inputLine.nextLine();

                    if (cofrinhoDesejado.equals(cofrinho01.cofrinho)){
                        cofrinho01.quebrarCofrinho();
                    }else if (cofrinhoDesejado.equals(cofrinho02.cofrinho)){
                        cofrinho02.quebrarCofrinho();
                    }else {
                        System.out.println("Cofrinho não existe");
                    }
                }
            }
        }
    }
}
