public class main{
    public static void main(String[] args){
        Carro carro1 = new Carro("Ford", "FordKa", "EEE-123");
        Carro carro2 = new Carro("Ford", "Fiesta", "BBB-321");
        carro1.exibirDados();
        carro2.exibirDados();

        Funcionario funcionario1 = new Funcionario("João", "Pedro", 500);
        Funcionario funcionario2 = new Funcionario("Pedro", "João", 1000);
        funcionario1.salarioAnual();
        funcionario2.salarioAnual();
        funcionario1.aumentarSalario();
        funcionario2.aumentarSalario();
        funcionario1.salarioAnual();
        funcionario2.salarioAnual();
        

    }
}