import java.util.List;

public class ExemploMetodo {
    //Retorno: void(não tem)
    //Argumentos: nome
    //Corpo: tudo que fica dentro de {}
    void apresentarUsuario(String nome){
        System.out.println("""
                Olá %s""".formatted(nome));
    }

    void apresentarUsuario(String nome, String sobrenome){
        System.out.println("""
                Olá %s %s """.formatted(nome, sobrenome));
    }

    // Método com retorno:
    // A taxa é de 20% do valor da renda caso o produto custe até 500 reais
    // Acima de 500, o valor é de 40%
    Double calcularTaxa(Double valorVenda){
        if (valorVenda<= 500){
            return valorVenda * 0.2;
        }else{
            return valorVenda * 0.4;
        }
    }

    void exibirNomes(List<String> nomes){
        for (int i =0; i< nomes.size(); i++){
            System.out.println("Nome: " + nomes.get(i));
        }
    }
}
