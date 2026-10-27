public class Main {

    public static void main(String[] args) {
        testeSondagemLinear();
        testeSondagemQuadratica();
        testeDispersaoDupla();
    }

    private static void testeSondagemLinear() {
        System.out.println("=== Sondagem linear (m = 23) ===");
        TabelaHash tabela = new TabelaSondagemLinear(23);
        int[] chaves = {44, 46, 49, 68, 71, 97, 26, 72, 27};
        for (int chave : chaves) {
            tabela.inserir(chave);
        }
        tabela.exibir();
        System.out.println("buscar(27) = " + tabela.buscar(27));
        System.out.println("buscar(99) = " + tabela.buscar(99));
        System.out.println("remover(26) = " + tabela.remover(26));
        System.out.println("buscar(72) = " + tabela.buscar(72));
        tabela.exibir();
    }

    private static void testeSondagemQuadratica() {
        System.out.println("=== Sondagem quadratica (m = 16) ===");
        TabelaHash tabela = new TabelaSondagemQuadratica(16);
        int[] chaves = {10, 26, 42, 58, 7, 23, 12};
        for (int chave : chaves) {
            tabela.inserir(chave);
        }
        tabela.exibir();
        System.out.println("buscar(58) = " + tabela.buscar(58));
        System.out.println("buscar(99) = " + tabela.buscar(99));
        System.out.println("remover(26) = " + tabela.remover(26));
        System.out.println("buscar(42) = " + tabela.buscar(42));
        tabela.exibir();
    }

    private static void testeDispersaoDupla() {
        System.out.println("=== Dispersao dupla (m = 7) ===");
        TabelaHash tabela = new TabelaDispersaoDupla(7);
        int[] chaves = {74, 92, 32, 70, 47};
        for (int chave : chaves) {
            tabela.inserir(chave);
        }
        tabela.exibir();
        System.out.println("buscar(70) = " + tabela.buscar(70));
        System.out.println("buscar(99) = " + tabela.buscar(99));
        System.out.println("remover(32) = " + tabela.remover(32));
        System.out.println("buscar(70) = " + tabela.buscar(70));
        tabela.exibir();
    }
}