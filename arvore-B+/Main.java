import java.util.ArrayList;
import java.util.List;

class Pagina {
    boolean folha;
    List<Integer> chaves = new ArrayList<>();
    List<Pagina> filhos = new ArrayList<>();
    Pagina proximo;

    Pagina(boolean folha) {
        this.folha = folha;
    }
}

class Divisao {
    int chave;
    Pagina direita;

    Divisao(int chave, Pagina direita) {
        this.chave = chave;
        this.direita = direita;
    }
}

class ArvoreBMais {
    private final int d;
    private Pagina raiz;

    ArvoreBMais(int d) {
        this.d = d;
    }

    public void inserir(int chave) {
        if (raiz == null) {
            raiz = new Pagina(true);
            raiz.chaves.add(chave);
            return;
        }
        Divisao div = inserir(raiz, chave);
        if (div != null) {
            Pagina novaRaiz = new Pagina(false);
            novaRaiz.chaves.add(div.chave);
            novaRaiz.filhos.add(raiz);
            novaRaiz.filhos.add(div.direita);
            raiz = novaRaiz;
        }
    }

    private Divisao inserir(Pagina p, int chave) {
        if (p.folha) {
            int i = 0;
            while (i < p.chaves.size() && p.chaves.get(i) < chave) i++;
            p.chaves.add(i, chave);
            if (p.chaves.size() > 2 * d) return dividirFolha(p);
            return null;
        }

        int i = 0;
        while (i < p.chaves.size() && chave >= p.chaves.get(i)) i++;

        Divisao div = inserir(p.filhos.get(i), chave);
        if (div == null) return null;

        p.chaves.add(i, div.chave);
        p.filhos.add(i + 1, div.direita);
        if (p.chaves.size() > 2 * d) return dividirInterna(p);
        return null;
    }

    private Divisao dividirFolha(Pagina folha) {
        Pagina nova = new Pagina(true);
        List<Integer> direita = folha.chaves.subList(d, folha.chaves.size());
        nova.chaves.addAll(direita);
        direita.clear();
        nova.proximo = folha.proximo;
        folha.proximo = nova;
        return new Divisao(nova.chaves.get(0), nova);
    }

    private Divisao dividirInterna(Pagina p) {
        Pagina nova = new Pagina(false);
        int sobe = p.chaves.get(d);
        nova.chaves.addAll(p.chaves.subList(d + 1, p.chaves.size()));
        nova.filhos.addAll(p.filhos.subList(d + 1, p.filhos.size()));
        p.chaves.subList(d, p.chaves.size()).clear();
        p.filhos.subList(d + 1, p.filhos.size()).clear();
        return new Divisao(sobe, nova);
    }

    public void imprimir() {
        List<Pagina> nivel = new ArrayList<>();
        if (raiz != null) nivel.add(raiz);
        int n = 0;
        while (!nivel.isEmpty()) {
            StringBuilder sb = new StringBuilder("Nível " + n++ + ": ");
            List<Pagina> proximoNivel = new ArrayList<>();
            for (Pagina p : nivel) {
                sb.append(p.chaves).append(" ");
                if (!p.folha) proximoNivel.addAll(p.filhos);
            }
            System.out.println(sb);
            nivel = proximoNivel;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBMais arvore = new ArvoreBMais(2);
        int[] valores = {2, 3, 5, 7, 11, 17, 19, 23, 29, 31};
        for (int v : valores) {
            arvore.inserir(v);
        }
        arvore.imprimir();
    }
}