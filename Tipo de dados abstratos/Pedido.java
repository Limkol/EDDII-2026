public class Pedido {

    private Saco<Produto> produtos;

    public Pedido() {
        produtos = new SacoVetor<>(10);
    }

    public void adicionarProduto(Produto produto) {
        produtos.inserir(produto);
    }

    public double calcularValor() {
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }

        return total;
    }
}