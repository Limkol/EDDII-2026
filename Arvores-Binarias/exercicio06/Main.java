public class Main {

    public static void main(String[] args) {
        Exercicios ex = new Exercicios();
        No raiz = construirArvore();

        // Teste Exercicio 2
        System.out.println("Exercício 2");
        System.out.println("Maior número <= 20: " + ex.maiorMenorOuIgual(raiz, 20));
        System.out.println("Maior número <= 35: " + ex.maiorMenorOuIgual(raiz, 35));
        System.out.println("Maior número <= 55: " + ex.maiorMenorOuIgual(raiz, 55));
        System.out.println();

        // Teste Exercicio 5
        System.out.println("Exercício 5");
        No no30 = encontrarNo(raiz, 30);
        No no35 = encontrarNo(raiz, 35);
        No no10 = encontrarNo(raiz, 10);

        if (no30 != null) {
            No pai30 = ex.encontrarPai(raiz, no30);
            System.out.println("Pai de 20: " + (pai30 != null ? pai30.valor : "null"));
        }
        if (no35 != null) {
            No pai35 = ex.encontrarPai(raiz, no35);
            System.out.println("Pai de 35: " + (pai35 != null ? pai35.valor : "null"));
        }
        if (no10 != null) {
            No pai10 = ex.encontrarPai(raiz, no10);
            System.out.println("Pai de 10: " + (pai10 != null ? pai10.valor : "null"));
        }
        System.out.println();

        // Teste Exercicio 6
        System.out.println("Exercício 6");
        System.out.println("Soma das folhas: " + ex.obterSomaFolhas(raiz));
    }

    private static No construirArvore() {
        No raiz = new No(30);
        raiz.esquerda = new No(15);
        raiz.direita = new No(45);
        raiz.esquerda.esquerda = new No(10);
        raiz.esquerda.direita = new No(25);
        raiz.direita.esquerda = new No(35);
        raiz.direita.direita = new No(50);

        return raiz;
    }

    private static No encontrarNo(No raiz, int valor) {
        if (raiz == null) {
            return null;
        }
        if (raiz.valor == valor) {
            return raiz;
        }
        if (valor < raiz.valor) {
            return encontrarNo(raiz.esquerda, valor);
        }
        return encontrarNo(raiz.direita, valor);
    }
}