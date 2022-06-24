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

    public static class RandomBox {
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

    public static int rand01(RandomBox randomBox) {
        int max = randomBox.getMax();
        int min = randomBox.getMin();
        int ans = 0;

//        int remainder = (max - min) % 2;
//        if (remainder == 1) {
//            //奇数有中间位
//            do {
//                ans = randomBox.random() < (max / 2) ? 0 : 1;
//            } while (ans == (max / 2 + 1));
//        } else {
//            //偶数不需要考虑中间位
//            ans = randomBox.random() < (max / 2) ? 0 : 1;
//        }
        int size = max - min + 1;
        boolean flag = (size & 1) != 0;
        int mid = size / 2;
        do {
            ans = randomBox.random() - min;
        } while (flag && ans == mid);

        return ans < mid ? 0 : 1;
    }

    // 借助RandomBox等概率返回form~to上的任意数字
    public static int random(RandomBox randomBox, int from, int to) {
        if (from == to) {
            return from;
        }
        int range = to - from;
        int bits = 0;
        while ((1 << bits) - 1 < range) {
            bits++;
        }
        int ans = 0;
        do {
            for (int i = 0; i < bits; i++) {
                ans |= (rand01(randomBox) << i);
            }
        } while (ans > range);

        return ans + from;
    }

    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    //非等概率出现随机数时，通过二次随机重构出一个等概率随机的方法

    public static void main(String[] args) {

        System.out.println(f());
    }
}
