package confeitaria;

public class App {
    public static void main(String[] args) {
        Bolo tipoBolo01 = new Bolo("Chocolate", 10.5, 6);
        Bolo tipoBolo02 = new Bolo("Morango", 12.70, 8);
        Bolo tipoBolo03 = new Bolo("Cenoura", 11.3, 0 );


        tipoBolo01.comprarBolo(1);
        tipoBolo02.comprarBolo(23);
        tipoBolo03.comprarBolo(40);

        tipoBolo01.comprarBolo(1);
        tipoBolo02.comprarBolo(9);
        tipoBolo03.comprarBolo(3);

        tipoBolo01.comprarBolo(1);
        tipoBolo02.comprarBolo(2);
        tipoBolo03.comprarBolo(32);

        tipoBolo01.comprarBolo(1);
        tipoBolo02.comprarBolo(23);
        tipoBolo03.comprarBolo(4);

        tipoBolo01.comprarBolo(1);
        tipoBolo02.comprarBolo(6);
        tipoBolo03.comprarBolo(8);

        tipoBolo01.getRelatorio();
        tipoBolo02.getRelatorio();
        tipoBolo03.getRelatorio();



    }
}
