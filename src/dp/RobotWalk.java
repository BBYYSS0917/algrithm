package dp;

/**
 * @author BaiJY
 * @date 2023/02/13
 **/
public class RobotWalk {

    //从顶向下的动态规划-记忆化搜索


    public static int ways1(int N, int start, int aim, int K) {
        return process(start, K, aim, N);
    }

    public static int process(int cur, int rest, int aim, int N) {
        //1. 递归实现 basecase
        //2. 缓存冗余
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(2, rest - 1, aim, N);
        }
        if (cur == N) {
            return process(N - 1, rest - 1, aim, N);
        }
        return process(cur - 1, rest - 1, aim, N) + process(cur + 1, rest - 1, aim, N);
    }

    public static int ways2(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(start, K, aim, N, dp);
    }

    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {

        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }

        //1. 递归实现 basecase
        //2. 缓存冗余
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }

        dp[cur][rest] = ans;
        return ans;
    }

    public static int ways3(int N, int start, int aim, int K) {
        //动态规划，推导dp数组的内容，
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(start, K, aim, N, dp);
    }

    public static void main(String[] args) {
        System.out.println(ways2(4, 2, 4, 4));
    }

}
