package binary;

import java.util.Arrays;

/**
 * 查询数组中最左侧匹配的数字
 *
 * @author BaiJY
 * @date 2022/07/18
 **/
public class BSNearLeft {

    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random()));
        }
        return arr;
    }

    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;

        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random()));
            if (test(arr, value) != mostLeftNoLessNumIndex(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(mostLeftNoLessNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck!");
    }

}
