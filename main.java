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
        Funcionario funcionario1 = new Funcionario("João", "Pedro", 500.00);
        Funcionario funcionario2 = new Funcionario("Pedro", "João", 1000.00);
        System.out.println(funcionario1.salarioAnual());
        System.out.println(funcionario2.salarioAnual());
        funcionario1.aumentarSalario();
        funcionario2.aumentarSalario();
        System.out.println(funcionario1.salarioAnual());
        System.out.println(funcionario2.salarioAnual());
        

    }
}