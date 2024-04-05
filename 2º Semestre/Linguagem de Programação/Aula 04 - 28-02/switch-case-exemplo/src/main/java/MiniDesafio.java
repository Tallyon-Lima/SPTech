import java.util.Scanner;

public class MiniDesafio {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        Integer numeroEscolhido;
        Integer n1;
        Integer n2;
        Integer n3 = 1;
        String operacao = "";
        Integer resultado = 0;
        Integer resultado2 = 0;

        Calculadora calc = new Calculadora();
        Utilitaria uti = new Utilitaria();

        uti.exibirMenu();
        numeroEscolhido = input.nextInt();
        while (numeroEscolhido != 1 &&  numeroEscolhido != 2 && numeroEscolhido != 3){
            System.out.println("Digite uma opção válida");
            numeroEscolhido = input.nextInt();
        }

        System.out.println("Digite o primeiro número");
        n1 = input.nextInt();
        System.out.println("Digite o segundo número");
        n2 = input.nextInt();

        switch (numeroEscolhido){
                case 1:
                resultado = calc.somar(n1 , n2);
                resultado2 = calc.somar(n1, n2, n3);
               operacao = "+";
                break;
                case 2:
                resultado = calc.subtrair(n1, n2);
                operacao = "-";
                break;
                case 3:
                resultado = calc.multiplicar(n1,n2);
                operacao = "*";
                break;
        }

        System.out.println("""
                %d %s %d = %d""".formatted(n1, operacao, n2, resultado2));

    }
}
