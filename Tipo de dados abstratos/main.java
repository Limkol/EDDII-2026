public class main{
    public static void main(String[] args){
        //Teste da classe Carro
        /*
        Carro carro1 = new Carro("Ford", "FordKa", "EEE-123");
        Carro carro2 = new Carro("Ford", "Fiesta", "BBB-321");
        carro1.exibirDados();
        carro2.exibirDados();
        */

        //Teste da classe Funcionario
        /*
        Funcionario funcionario1 = new Funcionario("João", "Pedro", 500.00);
        Funcionario funcionario2 = new Funcionario("Pedro", "João", 1000.00);
        System.out.println(funcionario1.salarioAnual());
        System.out.println(funcionario2.salarioAnual());
        funcionario1.aumentarSalario();
        funcionario2.aumentarSalario();
        System.out.println(funcionario1.salarioAnual());
        System.out.println(funcionario2.salarioAnual());
        */

        //Teste das classe SacoVetor<T>
        /*
        Saco<String> sacoVetor = new SacoVetor<>(5);

        sacoVetor.inserir("Maçã");
        sacoVetor.inserir("Banana");
        sacoVetor.inserir("Uva");

        System.out.println("SACO VETOR:");

        for (String fruta : sacoVetor) {
            System.out.println(fruta);
        }

        System.out.println("Está vazio? " + sacoVetor.vazio());
        */

        //Teste da classe SacoListaEncadeada<T>
        /*
        Saco<String> sacoLista = new SacoListaEncadeada<>();

        sacoLista.inserir("Laranja");
        sacoLista.inserir("Morango");
        sacoLista.inserir("Abacaxi");

        System.out.println("SACO LISTA ENCADEADA:");

        for (String fruta : sacoLista) {
            System.out.println(fruta);
        }

        System.out.println("Está vazio? " + sacoLista.vazio());
        */

        //Teste das classe Aluno
        /*
        Aluno aluno1 = new Aluno("001", "Gustavo", "3A");
        Aluno aluno2 = new Aluno("002", "João", "3A");

        aluno1.inserirNota(8.0);
        aluno1.inserirNota(7.5);
        aluno1.inserirNota(9.0);

        aluno2.inserirNota(6.0);
        aluno2.inserirNota(7.0);
        aluno2.inserirNota(8.5);

        System.out.println("Aluno: Gustavo");
        System.out.printf("Média: %.2f%n", aluno1.calcularMedia());

        System.out.println("\nAluno: João");
        System.out.printf("Média: %.2f%n", aluno2.calcularMedia());
        */

        //Teste das classes Pedido e Produto
        /*
        Produto cafe = new Produto("Café solúvel", 5.50, 1);
        Produto arroz = new Produto("Arroz integral", 4.90, 2);
        Produto feijao = new Produto("Feijão preto", 2.80, 2);

        Pedido meuPedido = new Pedido();

        meuPedido.adicionarProduto(cafe);
        meuPedido.adicionarProduto(arroz);
        meuPedido.adicionarProduto(feijao);

        System.out.printf("O valor total é: %.2f%n", meuPedido.calcularValor());
        */

        //Teste das classes Cofre e Moeda
        Moeda moeda1 = new Moeda(0.25);
        Moeda moeda2 = new Moeda(0.50);
        Moeda moeda3 = new Moeda(1.00);

        Cofre cofre = new Cofre();

        cofre.adicionar(moeda1);
        cofre.adicionar(moeda2);
        cofre.adicionar(moeda3);

        System.out.printf("O valor total é: %.2f%n", cofre.calcularTotal());
    }
}