public class Calculadora {
    //Void tipo de retorno
    // "exibirTexto" nome do projeto, escreve como se fosse criar uma variavel
    // "String nome" é o argumento, opcional
     Integer somar(Integer num1, Integer num2){
if (num1 != null && num2 != null){
    Integer total = num1 + num2;
    return num1+ num2;
}else {
    return 0;
}

    }

    Integer subtrair(Integer num1, Integer num2){
         return num1 - num2;
    }

    Integer multiplicar(Integer num1, Integer num2){
         return  num1 * num2;
    }

    Integer somar( Integer num1, Integer num2, Integer num3) {
        return  somar(num1 , num2)+ num3;
    }

    Double multiplicar(Integer num1, Double num2){
         return num1 * num2;
    }
}
