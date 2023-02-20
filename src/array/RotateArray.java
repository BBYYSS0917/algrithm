package array;

import utils.Utils;

/**
 * @author BaiJY
 * @date 2023/02/20
 **/
public class RotateArray {
    public static void main(String[] args) {

        int[] arr = new int[]{-1};
        rotate2(arr, 2);

//        reverse(arr, 0, 6);
        Utils.printIntArr(arr);
    }

    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void rotate2(int[] nums, int k) {
        k %= nums.length; //避免k大于数组长度
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
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
