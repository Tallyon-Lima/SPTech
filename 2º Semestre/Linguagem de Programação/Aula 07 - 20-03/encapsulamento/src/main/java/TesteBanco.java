import java.util.Scanner;

public class TesteBanco {
    public static void main(String[] args) {
        Scanner inputInteger = new Scanner (System.in);
        Scanner inputDouble = new Scanner(System.in);


         ContaBancaria conta01 = new ContaBancaria(
                 "Tallyon",
                 "123456890",
                 001);

         ContaBancaria conta02 = new ContaBancaria("Caramelo",
                 "0987654321",
                 002);

         ContaBancaria conta03 = new ContaBancaria();


        // Maneira com o atributo private
        // conta01.setNomeTitular("Tallyon");
        // System.out.println("Nome do titular da conta "+ conta01.getNomeTitular());


    }

}
