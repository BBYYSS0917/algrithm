package DS;

/**
 * 自定义stack实现
 * @author Donquixote
 */
public interface SelfStack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
