package utils;

/**
 * Java 随机函数测试
 *
 * @author BaiJY
 * @date 2022/06/22
 **/
public class RandTest {
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    //等概率获取1和3
    public static int a() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    //等概率返回0-6
    public static int b() {
        int ans = 0;
        do {
            ans = (a() << 2) + (a() << 1) + a();
        } while (ans == 7);
        return ans;
    }

    //等概率返回1-7
    public static int c() {
        return b() + 1;
    }

    public static class RandomBox{
        private int min;
        private int max;

        public RandomBox(int mi, int ma) {
            min = mi;
            max = ma;
        }

        public int random() {
            return min + (int) (Math.random() * (max - min + 1));
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

    public static void main(String[] args) {

        System.out.println(f());
    }
}
