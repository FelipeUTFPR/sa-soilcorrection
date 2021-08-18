package conversao;

public interface Conversao<T, R> {

    public R converte(T valor);
}
