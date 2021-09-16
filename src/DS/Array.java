package DS;

/**
 * 二次封装数组类
 *
 * @author Donquixote
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    private Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(E e) {
        // 判断还能否添加元素
        validateArrayCapacity();
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        validateArrayCapacity();
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
//        if (index > size) {
//            for (int i = size; i < index; i++) {
//                data[i] = 0;
//            }
//        }
        if (index < size) {
            for (int i = size-1; i >= index; i--) {
                data[i + 1] = data[i];
            }
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("DS.Array:size=%d,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 校验数组容量
     */
    public void validateArrayCapacity() {
        if (this.getSize() == this.getCapacity()) {
            throw new IllegalArgumentException("Add failed!DS.Array is full");
        }
    }
}
