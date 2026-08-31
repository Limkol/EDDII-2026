public class main2 {

    public static void main(String[] args) {

        // Teste das classes Pessoa, PessoaFisica e PessoaJuridica
        /*
        Pessoa pessoa1 = new Pessoa(1, "Nome da Pessoa");

        PessoaJuridica p_juridica = new PessoaJuridica(2, "Nome da Pessoa Juridica", "1111111111");

        PessoaFisica p_fisica = new PessoaFisica(3, "Nome da Pessoa Fisica", "222222222", "333333333");

        System.out.printf("Id: %d\n", pessoa1.identificador);
        System.out.println("Nome: " + pessoa1.nome);

        System.out.printf("Id: %d\n", p_juridica.identificador);
        System.out.println("Nome: " + p_juridica.nome);
        System.out.println("CNPJ: " + p_juridica.cnpj);

        System.out.printf("Id: %d\n", p_fisica.identificador);
        System.out.println("Nome: " + p_fisica.nome);
        System.out.println("RG: " + p_fisica.rg);
        System.out.println("CPF: " + p_fisica.cpf);
        */

        //Teste das classes Animal e Cachorro
        /*
        Animal animal = new Animal("Passarinho", "Azul", 2);
        animal.exibir_dados();

        Cachorro dog = new Cachorro("Rex", "Marrom", 4, "Vira lata");
        dog.exibir_dados();
        */

        //Teste das classes Imovel, ImovelNovo e ImovelVelho
        /*
        Imovel imovel = new Imovel("Rua Silva, 123", 300000.0);
        ImovelNovo imovel_novo = new ImovelNovo("Rua Joaquim, 999", 250000.0, 20000.0);
        ImovelVelho imovel_velho = new ImovelVelho("Av. Brasil, 777", 500000.0, 35000.0);

        System.out.println(imovel.endereco);
        System.out.printf("Preço: %.2f%n", imovel.preco);

        System.out.println(imovel_novo.endereco);
        System.out.printf("Preço: %.2f%n", imovel_novo.preco);
        System.out.printf("Preço atual: %.2f%n", imovel_novo.calcular_preco());

        System.out.println(imovel_velho.endereco);
        System.out.printf("Preço: %.2f%n", imovel_velho.preco);
        System.out.printf("Preço atual: %.2f%n", imovel_velho.calcular_preco());
        */

        //Teste das classes Carro, Motor, Veiculo, Caminhao
        Motor motor1 = new Motor(1000, 500);
        Motor motor2 = new Motor(8000, 900);
        Carro carro = new Carro(2010,20000,motor1,"branca","gol");
        Caminhao caminhao = new Caminhao(2015,80000,motor2,10);

        carro.exibirDados();
        caminhao.exibirDados();
    }
}