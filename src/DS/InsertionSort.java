package DS;

/**
 * 选择排序
 *
 * @author Donquixote
 */
public class InsertionSort {

    // 新的元素和之前已经排好序的数组依次排

    private InsertionSort() {
    }

    public static <E extends Comparable> void sort(E[] arr) {
        // 构建循环不变量
        for (int i = 0; i < arr.length; i++) {
            // 每次内循环最终变量应该存放的地址
            E tmpValue = arr[i];
            int j;
            for (j = i; j >= 1; j--) {
                if (tmpValue.compareTo(arr[j - 1]) < 0) {
                    // 方式1：交换值
//                    DS.InsertionSort.swap(arr, j, j - 1);
                    // 优化，减少交换次数，将每次校验的值临时存储，比较时将数据变化的值动态移动
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = tmpValue;
        }
    }

    private static <E> void swap(E[] arr, int index1, int index2) {
        E tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 4, 6, 5, 3};
        InsertionSort.sort(arr);
        String res = "";
        for (Integer i : arr) {
            System.out.println(res + i + " ");
        }
    }
}
