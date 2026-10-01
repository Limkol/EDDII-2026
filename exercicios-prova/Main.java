public class Main {

    static No inserir(No p, int valor) {
        if (p == null) return new No(valor);
        if (valor < p.chave) p.esq = inserir(p.esq, valor);
        else if (valor > p.chave) p.dir = inserir(p.dir, valor);
        return p;
    }

    public static void main(String[] args) {
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 35, 55, 65, 90, 38};

        No raiz = null;
        for (int v : valores)
            raiz = inserir(raiz, v);

        System.out.println("Arvore montada");

        System.out.println("\nExercicio 1 -");

        System.out.println("Nos da esquerda festiva: " + Exercicio1.esqFestiva(raiz) + "\n");

        System.out.println("Exercicio 2 -");
        int valorEscolhido = 40;
        int sucessor = Exercicio2.sucessor(raiz, valorEscolhido);
        System.out.println("Valor escolhido: " + valorEscolhido + " | Sucessor: " + sucessor);
    }
}