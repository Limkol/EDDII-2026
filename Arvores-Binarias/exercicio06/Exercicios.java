public class Exercicios {

    // Exercício 2
    public int maiorMenorOuIgual(No raiz, int n) {
        int resultado = -1;
        No atual = raiz;

        while (atual != null) {
            if (atual.valor <= n) {
                resultado = atual.valor;
                atual = atual.direita;
            } else {
                atual = atual.esquerda;
            }
        }

        return resultado;
    }

    // Exercício 5
    public No encontrarPai(No raiz, No no) {
        if (raiz == null || raiz == no) {
            return null;
        }

        No atual = raiz;
        while (atual != null) {
            if (no.valor < atual.valor) {
                if (atual.esquerda == no) {
                    return atual;
                }
                atual = atual.esquerda;
            } else if (no.valor > atual.valor) {
                if (atual.direita == no) {
                    return atual;
                }
                atual = atual.direita;
            } else {
                return null;
            }
        }

        return null;
    }

    // Exercício 6
    private int somaFolhas(No p) {
        if (p == null) {
            return 0;
        }

        if (p.esquerda == null && p.direita == null) {
            return p.valor;
        }

        return somaFolhas(p.esquerda) + somaFolhas(p.direita);
    }

    public int obterSomaFolhas(No raiz) {
        return somaFolhas(raiz);
    }
}