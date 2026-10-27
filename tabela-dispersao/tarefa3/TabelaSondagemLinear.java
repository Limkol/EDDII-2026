public class TabelaSondagemLinear extends TabelaHash {

    public TabelaSondagemLinear(int m) {
        super(m);
    }

    private int h(int chave) {
        return Math.floorMod(chave, m);
    }

    @Override
    protected int endereco(int chave, int k) {
        return (h(chave) + k) % m;
    }
}