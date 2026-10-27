public abstract class TabelaHash {
    protected static final byte VAZIO = 0;
    protected static final byte OCUPADO = 1;
    protected static final byte REMOVIDO = 2;

    protected final int m;
    protected final int[] chaves;
    protected final byte[] estados;

    public TabelaHash(int m) {
        this.m = m;
        this.chaves = new int[m];
        this.estados = new byte[m];
    }

    protected abstract int endereco(int chave, int k);

    public boolean inserir(int chave) {
        if (buscar(chave) != -1) {
            return false;
        }
        for (int k = 0; k < m; k++) {
            int pos = endereco(chave, k);
            if (estados[pos] != OCUPADO) {
                chaves[pos] = chave;
                estados[pos] = OCUPADO;
                return true;
            }
        }
        return false;
    }

    public int buscar(int chave) {
        for (int k = 0; k < m; k++) {
            int pos = endereco(chave, k);
            if (estados[pos] == VAZIO) {
                return -1;
            }
            if (estados[pos] == OCUPADO && chaves[pos] == chave) {
                return pos;
            }
        }
        return -1;
    }

    public boolean remover(int chave) {
        int pos = buscar(chave);
        if (pos == -1) {
            return false;
        }
        estados[pos] = REMOVIDO;
        return true;
    }

    public void exibir() {
        for (int i = 0; i < m; i++) {
            String conteudo;
            if (estados[i] == OCUPADO) {
                conteudo = String.valueOf(chaves[i]);
            } else if (estados[i] == REMOVIDO) {
                conteudo = "removido";
            } else {
                conteudo = "-";
            }
            System.out.println(i + ": " + conteudo);
        }
    }
}