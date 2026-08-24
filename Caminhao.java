public class Caminhao extends Veiculo {

    public float comprimento;

    public Caminhao(int ano, float preco, Motor motor, float comprimento) {
        super(ano, preco, motor);

        this.comprimento = comprimento;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();

        System.out.println("Comprimento: " + comprimento);
    }
}