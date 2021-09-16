package DS;

/**
 * 尾递归调用测试
 */
public class RTest {


    public int fun(int n, int r) {
        return n == 1 ? r : fun(n - 1, n + r);
    }

    public static void main(String[] args) {
        RTest r = new RTest();
        System.out.println(r.fun(100, 1)    );
    }
}
