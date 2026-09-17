public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();
        int[] valores = {34, 3, 50, 20, 15, 16, 25, 27};

        System.out.println("\nInserindo valores: " + java.util.Arrays.toString(valores));
        System.out.println();

        for (int valor : valores) {
            arvore.inserir(valor);
            System.out.println("Inserido: " + valor);
        }

        arvore.exibirArvore();
        arvore.exibirEmOrdem();

        System.out.println("\n--- VERIFICAÇÃO DE PROPRIEDADES ---");
        System.out.println("Tamanho da árvore: " + arvore.getTamanhoDaArvore());
        System.out.println("Altura da árvore: " + arvore.getAltura());
        System.out.println("Altura negra: " + arvore.calcularAlturaNegra());
        System.out.println("Propriedades válidas: " + (arvore.verificarPropriedades() ? "SIM" : "NÃO"));

        System.out.println();
   
        int[] buscar = {20, 100, 34, 27, 1, 50};

        System.out.println("Buscando valores:");
        for (int valor : buscar) {
            boolean encontrado = arvore.buscar(valor);
            System.out.println("  Buscar " + valor + ": " + (encontrado ? "ENCONTRADO" : "NÃO ENCONTRADO"));
        }

        System.out.println();
    }
}