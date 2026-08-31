public class ImovelNovo extends Imovel {

    public double adicional;

    public ImovelNovo(String endereco, double preco, double adicional) {
        super(endereco, preco);
        this.adicional = adicional;
    }

    public double calcular_preco() {
        return preco + adicional;
    }
}