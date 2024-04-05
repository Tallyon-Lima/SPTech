public class Main {
    public static void main(String[] args) {
        Atividade atividade01 = new Atividade(
                "Tomar banho",
                "Tallyon",
                3);

        System.out.println(atividade01.toString());

        atividade01.terminarAtividade(3);
        System.out.println("""
        
        ------------------------------------------------
        
        """);
        System.out.println(atividade01.toString());
        System.out.println("""
        
        ------------------------------------------------
        
        """);
        atividade01.exibirRelatorio();
    }

}
