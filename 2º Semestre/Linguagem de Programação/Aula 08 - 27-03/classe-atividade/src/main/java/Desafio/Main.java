package Desafio;

public class Main {
    public static void main(String[] args) {
        Loja loja01 = new Loja("Loja Teste", 5);



        System.out.println("Inicio do Dia:" + loja01.toString());
        System.out.println("--------------------------");
        loja01.realizarVenda(44.0);
        loja01.realizarVenda(23.32);
        System.out.println(loja01.toString());
        System.out.println("--------------------------");
        loja01.realizarVenda(93.21, 10.0);
        System.out.println(loja01.toString());
        System.out.println("--------------------------");
        loja01.verificarMeta();
        loja01.realizarVenda(21.21, 10.0);
        System.out.println("--------------------------");
        System.out.println(loja01.toString());
        System.out.println("--------------------------");
        loja01.realizarVenda(241.21);
        loja01.verificarMeta();
        System.out.println("--------------------------");


    }
}
