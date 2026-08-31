public class Veiculo {

    public int ano;
    public float preco;
    public Motor motor;

    public Veiculo(int ano, float preco, Motor motor) {
        this.ano = ano;
        this.preco = preco;
        this.motor = motor;
    }

    public void exibirDados() {
        System.out.println("Ano: " + ano);
        System.out.println("Preço: " + preco);

        motor.exibirDados();
    }
}