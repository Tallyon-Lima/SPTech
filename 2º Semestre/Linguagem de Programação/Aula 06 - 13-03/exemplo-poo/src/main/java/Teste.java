public class Teste {
    public static void main(String[] args) {

        BilheteUnico bilhete01 = new BilheteUnico();

        bilhete01.nomeTitular = "Tallyon";
        bilhete01.saldo = 0.0;
        bilhete01.codigo = "b001";

        BilheteUnico bilhete02 = new BilheteUnico();
        bilhete02.nomeTitular = "Lima";
        bilhete02.saldo = 2.0;
        bilhete02.codigo = "b002";

        bilhete01.carregar(22.0);
        System.out.println("Saldo bilhete 01: " + bilhete01.saldo);

        bilhete02.carregar(-10.50);
        System.out.println("Saldo bilhete 02: " + bilhete02.saldo);
    }
}
