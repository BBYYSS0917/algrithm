package dp;

/**
 * @author BaiJY
 * @date 2023/02/13
 **/
public class Fib {
    public static void main(String[] args) {

        System.out.println(fib(84));
    }
    // 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。
    // 千万不要看不起暴力解，动态规划问题最困难的就是写出这个暴力解，即状态转移方程。

    public int fib2(int n){
        int[] arr=new int[n-1];
        if(n<=1){
            return n;
        }

        return fib(n-1)+fib(n-2);
    }

    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int a = 1, b = 0;
        for (int i = 2; i <= n; i++) {
            a = a + b;
            b = a - b;
            //为了防止中途溢出，每次计算都需要取模
            a %= 1000000007;
        }

        return a;
    }
}
