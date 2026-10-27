public class TabelaSondagemQuadratica extends TabelaHash {

    public TabelaSondagemQuadratica(int m) {
        super(m);
        if (m < 2 || (m & (m - 1)) != 0) {
            throw new IllegalArgumentException("m deve ser potencia de 2");
        }
    }

    private int h(int chave) {
        return Math.floorMod(chave, m);
    }

    @Override
    protected int endereco(int chave, int k) {
        return (h(chave) + k * (k + 1) / 2) % m;
    }
}