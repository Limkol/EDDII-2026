public class TabelaHash {

    private static class No {
        int chave;
        String dado;
        No prox;

        No(int chave, String dado) {
            this.chave = chave;
            this.dado = dado;
            this.prox = null;
        }
    }

    private No[] tabela;
    private int m;
    private int n;

    public TabelaHash(int m) {
        if (m <= 0) {
            throw new IllegalArgumentException("m deve ser maior que zero");
        }
        this.m = m;
        this.n = 0;
        this.tabela = new No[m];
    }

    private int hash(int chave) {
        return Math.floorMod(chave, m);
    }

    public boolean inserir(int chave, String dado) {
        int pos = hash(chave);
        No atual = tabela[pos];
        No ultimo = null;

        while (atual != null) {
            if (atual.chave == chave) {
                System.out.println("Chave " + chave + " já cadastrada.");
                return false;
            }
            ultimo = atual;
            atual = atual.prox;
        }

        No novo = new No(chave, dado);
        if (ultimo == null) {
            tabela[pos] = novo;
        } else {
            ultimo.prox = novo;
        }
        n++;
        return true;
    }

    public String buscar(int chave) {
        int pos = hash(chave);
        No atual = tabela[pos];

        while (atual != null) {
            if (atual.chave == chave) {
                return atual.dado;
            }
            atual = atual.prox;
        }
        return null;
    }

    public boolean remover(int chave) {
        int pos = hash(chave);
        No atual = tabela[pos];
        No anterior = null;

        while (atual != null) {
            if (atual.chave == chave) {
                if (anterior == null) {
                    tabela[pos] = atual.prox;
                } else {
                    anterior.prox = atual.prox;
                }
                n--;
                return true;
            }
            anterior = atual;
            atual = atual.prox;
        }
        System.out.println("Chave " + chave + " não encontrada.");
        return false;
    }

    public double fatorDeCarga() {
        return (double) n / m;
    }

    public void imprimir() {
        System.out.println("Tabela (m = " + m + ", n = " + n
                + ", fator de carga = " + String.format("%.2f", fatorDeCarga()) + ")");
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(": ");
            No atual = tabela[i];
            if (atual == null) {
                sb.append("(vazio)");
            }
            while (atual != null) {
                sb.append("[").append(atual.chave).append("]");
                if (atual.prox != null) {
                    sb.append(" -> ");
                }
                atual = atual.prox;
            }
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TabelaHash tab = new TabelaHash(7);

        System.out.println("Inserindo 11");
        tab.inserir(11, "Ana");
        tab.imprimir();

        System.out.println("Inserindo 10");
        tab.inserir(10, "Bruno");
        tab.imprimir();

        System.out.println("Inserindo 23");
        tab.inserir(23, "Carla");
        tab.imprimir();

        System.out.println("Inserindo 51");
        tab.inserir(51, "Fabio");
        tab.imprimir();

        System.out.println("Inserindo 30");
        tab.inserir(30, "Gabi");
        tab.imprimir();

        System.out.println("Inserindo 50");
        tab.inserir(50, "Elisa");
        tab.imprimir();

        System.out.println("Removendo 51");
        tab.remover(51);
        tab.imprimir();

        System.out.println("Buscando 30");
        String resultado = tab.buscar(30);
        System.out.println(resultado != null ? "Encontrado: " + resultado : "Não encontrado");
    }
}