public class Aluno {
    private String ra;
    private String nome;
    private String turma;
    private Saco<Double> notas;

    public Aluno(String ra, String nome, String turma) {
        this.ra = ra;
        this.nome = nome;
        this.turma =  turma;
        this.notas = new SacoVetor<>(10);
    }

    public void inserirNota(double nota) {
        notas.inserir(nota);
    }

    public double calcularMedia() {
        double soma = 0;
        int quantidade = 0;

        for (double nota : notas) {
            soma += nota;
            quantidade++;
        }

        return soma / quantidade;
    }
}