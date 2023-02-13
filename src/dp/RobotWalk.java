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
        return 0;
    }

}
