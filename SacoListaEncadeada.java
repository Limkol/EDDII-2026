import java.util.Iterator;

public class SacoListaEncadeada<T> implements Saco<T> {

	class No<T1>{
		T1 item;
		No<T1> prox;
	}
	
	No<T> inicio;

	@Override
	public Iterator<T> iterator() {
	    return new Iterator<T>() {

	        private No<T> atual = inicio;

	        @Override
	        public boolean hasNext() {
	            return atual != null;
	        }

	        @Override
	        public T next() {
	            T item = atual.item;
	            atual = atual.prox;
	            return item;
	        }
	    };
	}

	@Override
	public void inserir(T item) {
		No<T> novo = new No<>();
		novo.item  = item;
		novo.prox = inicio;
		inicio = novo;
	}

	@Override
	public boolean vazio() {
		return inicio == null;
	}

}
