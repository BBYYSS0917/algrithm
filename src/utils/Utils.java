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
}
