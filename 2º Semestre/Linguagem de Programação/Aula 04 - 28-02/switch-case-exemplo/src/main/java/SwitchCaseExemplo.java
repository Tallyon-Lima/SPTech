import javax.swing.text.Style;
import java.util.Scanner;

public class SwitchCaseExemplo {
    public static void main(String[] args) {
            Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um número de dia da semana: ");
        Integer diaDaSemana = leitor.nextInt();

        switch (diaDaSemana){
            case 1:
                System.out.println("Dia de fut");
                break;
            case 2:
                System.out.println("Segunda");
                break;
                case 3:
                System.out.println("Terça");
                    break;
            case  4:
                System.out.println("Aula de LP!");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sextouuuuuu");
                break;
            case 7:
                System.out.println("Sabadou");
                break;
            default:
                System.out.println("Você não digitou nenhum número válido");
        }

        // Switch case mais moderno, coloca o break automaticamente. Exxecuta somente uma isntrução
        switch (diaDaSemana) {
            case 1 -> {
                System.out.println("Dia de fut");
                System.out.println("banana");
            }
            case 2 -> System.out.println("Segunda");
            case 3 -> System.out.println("Terça");
            case 4 -> System.out.println("Aula de LP!");
            case 5 -> System.out.println("Quinta");
            case 6 -> System.out.println("Sextouuuuuu");
            case 7 -> System.out.println("Sabadou");
            default -> System.out.println("Você não digitou nenhum número válido");
        }


        // Exemplo com “String”
        String fruta = "Maça";
        switch (fruta.toLowerCase()){
            case "maça":
                System.out.println("Temos no estoque!");
                break;
            case "Melancia":
                System.out.println("Não temos no estoque!");
                break;
        }
    }
}
