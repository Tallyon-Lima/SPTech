package encomendas;

import java.util.Scanner;

public class EncomendaMain {
    public static void main(String[] args) {
        Encomenda pedido01 = new Encomenda();
        Encomenda pedido02 = new Encomenda();


        pedido01.setTamanho("G");
        pedido01.setEnderecoDestinatario("Av Dr. Pedro, 255");
        pedido01.setEnderecoRemetente("Rua Santos da Glória, 18");
        pedido01.setDistancia(42.2);
        pedido01.setValorEncomenda(87.50);


        pedido02.setTamanho("P");
        pedido02.setEnderecoDestinatario("Av D. João, 1950");
        pedido02.setEnderecoRemetente("Av Dr. Pedro, 18");
        pedido02.setDistancia(201.0);
        pedido02.setValorEncomenda(62.25);


        pedido01.calcularFrete();
        pedido02.calcularFrete();
        pedido01.getEtiqueta();
        pedido02.getEtiqueta();

    }
}
