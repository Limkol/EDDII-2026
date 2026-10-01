public class No {
    int chave;
    No esq;
    No dir;

    public No(int chave) {
        this.chave = chave;
        this.esq = null;
        this.dir = null;
    }
}