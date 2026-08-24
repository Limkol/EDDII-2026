public class ImovelVelho extends Imovel {

    public double desconto;

    public ImovelVelho(String endereco, double preco, double desconto) {
        super(endereco, preco);
        this.desconto = desconto;
    }

    public double calcular_preco() {
        return preco - desconto;
    }
}