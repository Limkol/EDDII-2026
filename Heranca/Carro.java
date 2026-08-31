public class Carro extends Veiculo {

    public String cor;
    public String modelo;

    public Carro(int ano, float preco, Motor motor, String cor, String modelo) {
        super(ano, preco, motor);

        this.cor = cor;
        this.modelo = modelo;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();

        System.out.println("Cor: " + cor);
        System.out.println("Modelo: " + modelo);
    }
}