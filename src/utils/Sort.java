package utils;

import java.util.Arrays;

/**
 * @author BaiJY
 * @date 2022/06/10
 **/
public class Sort {
    public static final int INVALID_ARRAY_LENGTH = 2;


    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6};
//        testBubbleSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        printArray(arr);

        testGenerateArray();
    }

    public static void selectSort(int[] array) {
        // 双重循环，每次选出该次循环的最小值
        // 循环中，找到比指定下标小的值就交换，这两个下标可能是不相邻的
        if (array == null || array.length < INVALID_ARRAY_LENGTH) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, j, i);
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        //双重循环，逐次比较两个相邻的数，每次大循环将一个最大值或最小值固定下来
        //最小或最大的值在不断移动
        if (array == null || array.length < INVALID_ARRAY_LENGTH) {
            return;
        }
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                int second = j + 1;
                if (array[j] > array[second]) {
                    swap(array, j, second);
                }
            }
        }

    }

    public static void insertSort(int[] array) {
        // 插入排序，一部分是已经排好序的，把新的值插入这些已经排好序的范围内
        if (array == null || array.length < INVALID_ARRAY_LENGTH) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while ((j >= 1) && (array[j] < array[j - 1])) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * swap array index value
     *
     * @param j index2
     * @param i index1
     */
    private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            int value = (int) (maxValue * Math.random());
            arr[i] = value;
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void testBubbleSort() {
        int[] arr = {7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6};
        bubbleSort(arr);
        printArray(arr);
    }

    public static void testGenerateArray() {
        int[] arr = generateRandomArray(20, 100);
        printArray(arr);
    }


}
