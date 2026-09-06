public class Exercicios {

    //1. Implementar a remoção recursiva.
    public static No removerRecursivo(No raiz, int valor) {

        if (raiz == null) {
            return null;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = removerRecursivo(raiz.esquerda, valor);
        }

        else if (valor > raiz.valor) {
            raiz.direita = removerRecursivo(raiz.direita, valor);
        }

        else {

            if (raiz.esquerda == null && raiz.direita == null) {
                return null;
            }

            if (raiz.esquerda == null) {
                return raiz.direita;
            }

            if (raiz.direita == null) {
                return raiz.esquerda;
            }

            No menor = raiz.direita;

            while (menor.esquerda != null) {
                menor = menor.esquerda;
            }

            raiz.valor = menor.valor;

            raiz.direita = removerRecursivo(raiz.direita, menor.valor);
        }

        return raiz;
    }


    //2. Implementar a remoção iterativa.
    public static No removerIterativo(No raiz, int valor) {

        No atual = raiz;
        No pai = null;

        while (atual != null && atual.valor != valor) {

            pai = atual;

            if (valor < atual.valor) {
                atual = atual.esquerda;
            }
            else {
                atual = atual.direita;
            }
        }

        if (atual == null) {
            return raiz;
        }

        if (atual.esquerda != null && atual.direita != null) {

            No paiMenor = atual;
            No menor = atual.direita;

            while (menor.esquerda != null) {
                paiMenor = menor;
                menor = menor.esquerda;
            }

            atual.valor = menor.valor;

            pai = paiMenor;
            atual = menor;
        }

        No filho;

        if (atual.esquerda != null) {
            filho = atual.esquerda;
        }
        else {
            filho = atual.direita;
        }

        if (pai == null) {
            raiz = filho;
        }

        else if (pai.esquerda == atual) {
            pai.esquerda = filho;
        }

        else {
            pai.direita = filho;
        }

        return raiz;
    }


    //3. Implementar o diagrama de barras, para mostrar os elementos da árvore binária de busca
    public static void diagrama(No raiz) {
        diagrama(raiz, "", true);
    }

    private static void diagrama(No no, String espacos, boolean ultimo) {

        if (no == null) {
            return;
        }

        System.out.print(espacos);

        if (ultimo) {
            System.out.print("`-- ");
            espacos += "    ";
        }
        else {
            System.out.print("|-- ");
            espacos += "|   ";
        }

        System.out.println(no.valor);

        diagrama(no.esquerda, espacos, false);
        diagrama(no.direita, espacos, true);
    }
}
