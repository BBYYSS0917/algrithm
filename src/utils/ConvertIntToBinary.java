package utils;

/**
 * 转换整数到二进制字符串
 * @author BaiJY
 * @date 2022/06/10
 **/
public class ConvertIntToBinary {
    public static void main(String[] args) {

        ConvertIntToBinary.print(Integer.MAX_VALUE);
        ConvertIntToBinary.print(Integer.MIN_VALUE);
        ConvertIntToBinary.print(-1);
    }

    static final int TOTAL_BITS = 31;

    public static String convertIntToBinary(int num) {
        int[] binaryArray = new int[32];

        // >> 算术右移，负数的话前位补1
        // >>> 逻辑右移，不论正负数前位都补0
        // declare java array: https://www.geeksforgeeks.org/arrays-in-java/

        for (int i = 0; i <= TOTAL_BITS; i++) {
            int res = (num >> i) & 1;
            binaryArray[TOTAL_BITS - i] = res;
        }
        // array的toString方法继承了Object的toString方法
        StringBuilder res = new StringBuilder();
        for (int j : binaryArray) {
            res.append(j);
        }
        return res.toString();
    }

    public static String convertIntToBinary2(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = TOTAL_BITS; i >= 0; i--) {
            String bit = (num & (1 << i)) == 0 ? "0" : "1";
            res.append(bit);
        }
        return res.toString();
    }

    public static void print(int num) {
        System.out.println(convertIntToBinary2(num));
    }
}
