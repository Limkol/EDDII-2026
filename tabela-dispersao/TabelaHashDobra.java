import java.util.ArrayList;
import java.util.List;

public class TabelaHashDobra {

    private final int digitosChave;
    private final int tamanhoDobra;
    private final int m;
    private final int[] chaves;
    private final int[] proximo;
    private final boolean[] ocupado;

    public TabelaHashDobra(int digitosChave, int tamanhoDobra) {
        this.digitosChave = digitosChave;
        this.tamanhoDobra = tamanhoDobra;
        this.m = (int) Math.pow(10, tamanhoDobra);
        this.chaves = new int[m];
        this.proximo = new int[m];
        this.ocupado = new boolean[m];
        for (int i = 0; i < m; i++) {
            proximo[i] = -1;
        }
    }

    private int hash(int chave) {
        String s = String.format("%0" + digitosChave + "d", chave);
        int t = tamanhoDobra;
        while (s.length() > t) {
            String primeiro = s.substring(0, t);
            String segundo = s.substring(t, 2 * t);
            String resto = s.substring(2 * t);
            StringBuilder soma = new StringBuilder();
            for (int i = 0; i < t; i++) {
                int a = primeiro.charAt(t - 1 - i) - '0';
                int b = segundo.charAt(i) - '0';
                soma.append((a + b) % 10);
            }
            s = soma + resto;
        }
        return Integer.parseInt(s);
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
        for (int i = m - 1; i >= 0; i--) {
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
        int cauda = proximo[atual];
        if (anterior != -1) {
            proximo[anterior] = -1;
        }
        ocupado[atual] = false;
        proximo[atual] = -1;
        List<Integer> reinserir = new ArrayList<>();
        while (cauda != -1) {
            reinserir.add(chaves[cauda]);
            int seguinte = proximo[cauda];
            ocupado[cauda] = false;
            proximo[cauda] = -1;
            cauda = seguinte;
        }
        for (int k : reinserir) {
            inserir(k);
        }
        return true;
    }

    public void exibir() {
        for (int i = 0; i < m; i++) {
            if (ocupado[i]) {
                String prox = proximo[i] == -1 ? "fim" : String.valueOf(proximo[i]);
                System.out.println(i + ": " + chaves[i] + " -> " + prox);
            }
        }
    }

    public static void main(String[] args) {
        TabelaHashDobra tabela = new TabelaHashDobra(6, 2);

        int[] entrada = {813459, 100243, 900009, 5, 10004, 900008};
        for (int chave : entrada) {
            tabela.inserir(chave);
        }

        System.out.println("Tabela apos insercoes:");
        tabela.exibir();

        System.out.println();
        System.out.println("Buscar 900008: " + tabela.buscar(900008));
        System.out.println("Buscar 123456: " + tabela.buscar(123456));

        System.out.println();
        System.out.println("Remover 100243: " + tabela.remover(100243));
        tabela.exibir();
    }
}