import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class main {

    // Exercício 1
    public static int contarNos(No no) {
        if (no == null) {
            return 0;
        }

        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    // Exercício 2
    public static int contarFolhas(No no) {
        if (no == null) {
            return 0;
        }

        if (no.esquerda == null && no.direita == null) {
            return 1;
        }

        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    // Exercício 3
    public static int contarNosInternos(No no) {
        if (no == null) {
            return 0;
        }

        if (no.esquerda == null && no.direita == null) {
            return 0;
        }

        return 1 + contarNosInternos(no.esquerda)
                 + contarNosInternos(no.direita);
    }

    // Exercício 4
    public static void preOrdem(No raiz) {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No no = pilha.pop();

            System.out.print(no.valor + " ");

            if (no.direita != null) {
                pilha.push(no.direita);
            }

            if (no.esquerda != null) {
                pilha.push(no.esquerda);
            }
        }

        System.out.println();
    }

    // Exercício 5
    public static void porNivel(No raiz) {
        if (raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No no = fila.remove();

            System.out.print(no.valor + " ");

            if (no.esquerda != null) {
                fila.add(no.esquerda);
            }

            if (no.direita != null) {
                fila.add(no.direita);
            }
        }

        System.out.println();
    }

    // Exercício 6 - Busca
    public static No buscar(No no, int valor) {
        if (no == null || no.valor == valor) {
            return no;
        }

        if (valor < no.valor) {
            return buscar(no.esquerda, valor);
        }

        return buscar(no.direita, valor);
    }

    // Exercício 6 - Inserção
    public static No inserir(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        }

        return no;
    }

    // Exercício 7
    public static int altura(No no) {
        if (no == null) {
            return 0;
        }

        return 1 + Math.max(
            altura(no.esquerda),
            altura(no.direita)
        );
    }

    public static void main(String[] args) {

        // Montando a árvore
        No raiz = new No(10);

        raiz.esquerda = new No(5);
        raiz.direita = new No(20);

        raiz.esquerda.esquerda = new No(3);
        raiz.esquerda.direita = new No(7);


        // Teste do Exercício 1
        System.out.println("Ex 1 - Total de nós: "
                + contarNos(raiz));


        // Teste do Exercício 2
        System.out.println("Ex 2 - Total de folhas: "
                + contarFolhas(raiz));


        // Teste do Exercício 3
        System.out.println("Ex 3 - Nós internos: "
                + contarNosInternos(raiz));


        // Teste do Exercício 4
        System.out.print("Ex 4 - Pré-ordem: ");
        preOrdem(raiz);


        // Teste do Exercício 5
        System.out.print("Ex 5 - Por nível: ");
        porNivel(raiz);


        // Teste do Exercício 6 - Busca
        int valor = 7;

        No resultado = buscar(raiz, valor);

        if (resultado != null) {
            System.out.println("Ex 6 - " + valor + " encontrado");
        } else {
            System.out.println("Ex 6 - " + valor + " não encontrado");
        }


        // Teste do Exercício 6 - Inserção
        raiz = inserir(raiz, 15);

        System.out.print("Depois de inserir 15: ");
        porNivel(raiz);


        // Teste do Exercício 7
        System.out.println("Ex 7 - Altura: "
                + altura(raiz));
    }
}