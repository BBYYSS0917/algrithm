package binary;

import utils.Sort;

import java.util.Arrays;

/**
 * 二分问题处理
 *
 * @author BaiJY
 * @date 2022/06/24
 **/
public class BSExist {

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    //二分查找指定数字的index
    public static int find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        int[] testArr = generateRandomArray(10, 10);
        int[] testArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(testArr);
        Sort.printArray(testArr);
        System.out.println("======");
//        System.out.println(find(testArr, testArr[testArr.length - 2]));
        System.out.println(find(testArr, 10));
    }
}
