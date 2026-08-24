public class PessoaFisica extends Pessoa {

    public String rg;
    public String cpf;

    public PessoaFisica(int identificador, String nome, String rg, String cpf) {
        super(identificador, nome);
        this.rg = rg;
        this.cpf = cpf;
    }
}