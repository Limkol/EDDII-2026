import java.util.Stack;

public class Exercicio2 {

    public static int sucessor(No raiz, int valor) {
        No p = raiz;
        Stack<No> pilha = new Stack<>();
        boolean achou = false;

        while (p != null || !pilha.isEmpty()) {
            if (p != null) {
                pilha.push(p);
                p = p.esq;
            } else {
                p = pilha.pop();
                if (achou) {
                    return p.chave;
                } else if (p.chave == valor) {
                    achou = true;
                }
                p = p.dir;
            }
        }

        if (achou)
            System.out.println("Ultimo elemento nao tem sucessor");
        else
            System.out.println("Valor " + valor + " nao encontrado na arvore");
        return -1;
    }

    public static void printSucessor(No raiz, int valor) {
        System.out.println("Sucessor de " + valor + ": " + sucessor(raiz, valor));
    }
}