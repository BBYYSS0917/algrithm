package DS;

/**
 * @author Donquixote
 */
public class LinerSearch {

    private LinerSearch(){}

    public static <E> int search(E[] data, E target) {

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int i = 0; i < data.length; i++) {
            if (data[i] == 6) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
