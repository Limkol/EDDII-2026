public class Funcionario {

    private String nome;
    private String sobrenome;
    private Double salarioMensal;

    public Funcionario(String nome, String sobrenome, Double salarioMensal) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        if (salarioMensal > 0){
            this.salarioMensal = salarioMensal;
        } else {
            this.salarioMensal = 0;
        }
    }

    public void aumentarSalario() {
        this.salarioMensal = this.salarioMensal * 1.10;
    }

    public Double() {
        return this.salarioMensal = this.salarioMensal * 12;
    }

}