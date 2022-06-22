package utils;

import java.security.InvalidParameterException;

/**
 * 前缀和，计算数组某一段范围的和，针对遍历情况的优化
 *
 * @author BaiJY
 * @date 2022/06/22
 **/
public class PreSum {
    public static class RangeSum {
        private int[] preSum;

        public RangeSum(int[] array) {
            preSum = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j <= i; j++) {
                    preSum[i] += array[j];
                }
            }
        }

        public int getPreSum(int l, int r) {
            if (l < 0 || l >= preSum.length) {
                throw new InvalidParameterException();
            }
            if (r < 0 || r >= preSum.length) {
                throw new InvalidParameterException();
            }
            return l == 0 ? preSum[r] : preSum[r] - preSum[l - 1];
        }
    }

    public static void main(String[] args) {
        RangeSum rangeSum = new RangeSum(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(rangeSum.getPreSum(0, 6));
    }
}
