public class TabelaHashMultiplicacao {

    private static final double A = (Math.sqrt(5) - 1) / 2;

    private final int[] chaves;
    private final int[] proximo;
    private final boolean[] ocupado;
    private final int p;
    private final int m;

    public TabelaHashMultiplicacao(int p, int s) {
        this.p = p;
        this.m = p + s;
        this.chaves = new int[m];
        this.proximo = new int[m];
        this.ocupado = new boolean[m];
        for (int i = 0; i < m; i++) {
            proximo[i] = -1;
        }
    }

    private int hash(int x) {
        double fracao = (x * A) % 1.0;
        return (int) (fracao * p);
    }

    private int posicao(int chave) {
        int i = hash(chave);
        if (!ocupado[i]) {
            return -1;
        }
        while (i != -1) {
            if (chaves[i] == chave) {
                return i;
            }
            i = proximo[i];
        }
        return -1;
    }

    private int posicaoLivre() {
        for (int i = m - 1; i >= p; i--) {
            if (!ocupado[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean buscar(int chave) {
        return posicao(chave) != -1;
    }

    public boolean inserir(int chave) {
        if (posicao(chave) != -1) {
            return false;
        }
        int i = hash(chave);
        if (!ocupado[i]) {
            chaves[i] = chave;
            proximo[i] = -1;
            ocupado[i] = true;
            return true;
        }
        int livre = posicaoLivre();
        if (livre == -1) {
            return false;
        }
        chaves[livre] = chave;
        proximo[livre] = -1;
        ocupado[livre] = true;
        while (proximo[i] != -1) {
            i = proximo[i];
        }
        proximo[i] = livre;
        return true;
    }

    public boolean remover(int chave) {
        int atual = hash(chave);
        if (!ocupado[atual]) {
            return false;
        }
        int anterior = -1;
        while (atual != -1 && chaves[atual] != chave) {
            anterior = atual;
            atual = proximo[atual];
        }
        if (atual == -1) {
            return false;
        }
        if (anterior == -1) {
            int prox = proximo[atual];
            if (prox == -1) {
                ocupado[atual] = false;
            } else {
                chaves[atual] = chaves[prox];
                proximo[atual] = proximo[prox];
                ocupado[prox] = false;
                proximo[prox] = -1;
            }
        } else {
            proximo[anterior] = proximo[atual];
            ocupado[atual] = false;
            proximo[atual] = -1;
        }
        return true;
    }

    public void exibir() {
        for (int i = 0; i < m; i++) {
            String zona = i < p ? "base" : "colisao";
            String conteudo;
            if (ocupado[i]) {
                String prox = proximo[i] == -1 ? "fim" : String.valueOf(proximo[i]);
                conteudo = chaves[i] + " -> " + prox;
            } else {
                conteudo = "vazio";
            }
            System.out.println(i + " [" + zona + "] " + conteudo);
        }
    }

    public static void main(String[] args) {
        TabelaHashMultiplicacao tabela = new TabelaHashMultiplicacao(7, 3);

        int[] entrada = {10, 15, 25, 30, 45, 40};
        for (int chave : entrada) {
            tabela.inserir(chave);
        }

        System.out.println("Tabela apos insercoes:");
        tabela.exibir();

        System.out.println();
        System.out.println("Buscar 30: " + tabela.buscar(30));
        System.out.println("Buscar 99: " + tabela.buscar(99));

        System.out.println();
        System.out.println("Remover 10: " + tabela.remover(10));
        tabela.exibir();
    }
}