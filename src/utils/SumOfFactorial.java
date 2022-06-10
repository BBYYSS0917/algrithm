package utils;

/**
 * @author BaiJY
 * @date 2022/06/10
 **/
public class SumOfFactorial {
    public static void main(String[] args) {

        System.out.println(sumFactorial(1));
        System.out.println(sumFactorial(2));
        System.out.println(sumFactorial(3));
    }

    public static long sumFactorial(int n) {
        if (n == 0) {
            return 0;
        }
        long answer = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur *= i;
            answer += cur;
        }
        return answer;
    }
}
