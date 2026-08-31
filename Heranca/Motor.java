public class Motor {

    public int cilindradas;
    public int potencia;

    public Motor(int cilindradas, int potencia) {
        this.cilindradas = cilindradas;
        this.potencia = potencia;
    }

    public void exibirDados() {
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("Potência: " + potencia);
    }
}