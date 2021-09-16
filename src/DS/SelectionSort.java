package DS;

/**
 * 选择排序
 *
 * @author Donquixote
 */
public class SelectionSort {

    private SelectionSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    int tmp = array[i];
//                    array[i] = array[j];
//                    array[j] = tmp;
//                }
            }
        }

    }


    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 5, 4, 3};
        SelectionSort.sort(intArray);
        for (int i : intArray) {
            System.out.println(i+" ");
        }
        System.out.println();
//        System.out.println(intArray);
    }

}
