package array;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BaiJY
 * @date 2023/02/16
 **/
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        Utils.printIntArr(plusOne2(digits));

//        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        // 大整数的溢出问题
        Long originNum = 0L;
        for (int i = 0; i < digits.length; i++) {
            originNum *= 10;
            originNum += digits[i];
        }
        originNum += 1;
        List<Long> res = new ArrayList<>();

        while (originNum > 0) {
            Long remainder = originNum % 10;
            originNum /= 10;
            res.add(remainder);
        }
        int index = 0;
        int[] out = new int[res.size()];
        for (Long num : res) {
            out[index] = Integer.valueOf(Math.toIntExact(res.get(res.size() - 1 - index)));
            index++;
        }

        return out;
    }

    public static int[] plusOne2(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return tmp;
    }
}
