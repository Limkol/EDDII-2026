public class Animal {

    public String nome;
    public String cor;
    public int quantidadePatas;

    public Animal(String nome, String cor, int quantidadePatas) {
        this.nome = nome;
        this.cor = cor;
        this.quantidadePatas = quantidadePatas;
    }

    public void exibir_dados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cor: " + cor);
        System.out.println("Quantidade de patas: " + quantidadePatas);
    }
}