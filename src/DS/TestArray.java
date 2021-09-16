package DS;

/**
 * 数组数据结构
 *
 * @author Donquixote
 */
public class TestArray {

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }


        int[] scores = new int[]{1, 2, 3, 4, 5};
        for (int i : scores) {
            System.out.println(i);
        }
    }
}
