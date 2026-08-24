import java.util.Iterator;

public class SacoVetor<T> implements Saco<T> {

    private T[] vetor;
    private int quantidade;

    public SacoVetor(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        quantidade = 0;
    }

    @Override
    public void inserir(T item) {
        vetor[quantidade] = item;
        quantidade++;
    }

    @Override
    public boolean vazio() {
        return quantidade == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int atual = 0;

            @Override
            public boolean hasNext() {
                return atual < quantidade;
            }

            @Override
            public T next() {
                return vetor[atual++];
            }
        };
    }
}