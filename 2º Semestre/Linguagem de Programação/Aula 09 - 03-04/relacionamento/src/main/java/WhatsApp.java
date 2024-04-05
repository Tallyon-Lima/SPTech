public class WhatsApp {

    public static void main(String[] args) {

        Contato contato01 = new Contato("Tallyon" , "(11) 978301733");
        Contato contato02 = new Contato("Lima", "(11) 1234567890");
        Contato contato03 = new Contato("Bob", "(11) 0987654321");
        Contato contato04 = new Contato("Tallyon" , "(11) 978301733");
        Contato contato05 = new Contato("Tallyon" , "(11) 978301733");
        Contato contato06 = new Contato("Tallyon" , "(11) 978301733");
        Contato contato07 = new Contato("Tallyon" , "(11) 978301733");

        Grupo grupo01 = new Grupo("Trabalho");
        Grupo grupo02 = new Grupo("Amigos");

        grupo01.adicionar(contato01);
        grupo01.adicionar(contato02);
        grupo01.adicionar(contato03);
        grupo01.adicionar(contato04);
        grupo01.adicionar(contato05);
        grupo01.adicionar(contato06);
        grupo01.adicionar(contato07 );

        grupo02.adicionar(contato03);
        grupo02.adicionar(contato01);

        System.out.println("Contato 01");
        System.out.println(contato01);
        System.out.println("-------------------------");
        System.out.println("Contato 02");
        System.out.println(contato02);
        System.out.println("-------------------------");
        System.out.println("Contato 03");
        System.out.println(contato03);
        System.out.println("-------------------------");
        System.out.println("Exibindo os grupos");
        System.out.println(grupo01);
        System.out.println("-------------------------");
        System.out.println(grupo02);
        grupo01.exibirPorNome("Tallyon");
    }
}
