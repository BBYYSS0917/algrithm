package utils;

/**
 * @author BaiJY
 * @date 2022/06/24
 **/
public class Utils {

    //生成随机数组
    public static int[] generateRandomArray(int maxLen,int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }

    public static void printIntArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            int tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
    }
}
