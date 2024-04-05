package empresa;

import java.util.Scanner;

public class TesteEmpregado {
    public static void main(String[] args) {
        Empregado funcionario = new Empregado();
        Scanner inputLine = new Scanner(System.in);
        Scanner inputInteger = new Scanner(System.in);

        funcionario.atribuirDados();
        funcionario.reajustarSalario(0.15);
        funcionario.imprimirDados();

        System.out.println("Digite quanto anos o funcionario esta na empresa");
        Integer anosTrabalhados = inputInteger.nextInt();
        funcionario.setAnosTrabalhados(anosTrabalhados);

        System.out.println("Ele foi promovido? (Sim/Não)");
        String promocao = inputLine.nextLine();
        funcionario.setPromocao(promocao);

        if (promocao.equals("Sim")){
            System.out.println("Qual o novo cargo?");
            String novoCargo = inputLine.nextLine();
            funcionario.setNovoCargo(novoCargo);
        }else{
            funcionario.setNovoCargo("Não foi promovido");;
        }

        funcionario.verificarPromocao();
    }
}
