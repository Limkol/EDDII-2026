public class TabelaDispersaoDupla extends TabelaHash {

    public TabelaDispersaoDupla(int m) {
        super(m);
        if (m < 3) {
            throw new IllegalArgumentException("m deve ser maior que 2");
        }
    }

    private int h1(int chave) {
        return Math.floorMod(chave, m);
    }

    private int h2(int chave) {
        return 1 + Math.floorMod(chave, m - 2);
    }

    @Override
    protected int endereco(int chave, int k) {
        return (h1(chave) + k * h2(chave)) % m;
    }
}