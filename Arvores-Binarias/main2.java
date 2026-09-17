public class main2 {

    public static void main(String[] args) {

        No raiz = new No(50);

        raiz.esquerda = new No(30);
        raiz.direita = new No(70);

        raiz.esquerda.esquerda = new No(20);
        raiz.esquerda.direita = new No(40);

        raiz.direita.esquerda = new No(60);
        raiz.direita.direita = new No(80);


        //Teste do diagrama de barras
        System.out.println("ARVORE ORIGINAL:");
        Exercicios.diagrama(raiz);


        //Teste da remoção recursiva
        System.out.println("\nREMOVENDO 30 - RECURSIVO:");
        raiz = Exercicios.removerRecursivo(raiz, 30);
        Exercicios.diagrama(raiz);


        //Teste da remoção iterativa
        System.out.println("\nREMOVENDO 70 - ITERATIVO:");
        raiz = Exercicios.removerIterativo(raiz, 70);
        Exercicios.diagrama(raiz);
    }

}
