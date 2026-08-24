public class Cofre {

    private Saco<Moeda> moedas;

    public Cofre() {
        moedas = new SacoVetor<>(10);
    }

    public void adicionar(Moeda moeda) {
        moedas.inserir(moeda);
    }

    public double calcularTotal() {
        double total = 0;

        for (Moeda moeda : moedas) {
            total += moeda.getValor();
        }

        return total;
    }
}