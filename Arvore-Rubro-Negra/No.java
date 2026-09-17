enum Cor {
    PRETO, VERMELHO
}

public class No {
    int valor;
    No esquerda;
    No direita;
    No pai;
    Cor cor;

    public No() {
        this.valor = 0;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = Cor.PRETO;
    }

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = Cor.VERMELHO;
    }

    @Override
    public String toString() {
        return valor + "(" + cor + ")";
    }
}