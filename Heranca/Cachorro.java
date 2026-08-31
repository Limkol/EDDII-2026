public class Cachorro extends Animal {

    public String raca;

    public Cachorro(String nome, String cor, int quantidadePatas, String raca) {
        super(nome, cor, quantidadePatas);
        this.raca = raca;
    }

    @Override
    public void exibir_dados() {
        super.exibir_dados();
        System.out.println("Raça: " + raca);
    }
}