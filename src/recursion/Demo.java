package recursion;

public class Demo {

    public static void hanoi1(int n) {

    }

    public static void main(String[] args) {
        // 1. 汉诺塔问题
    }

    public static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }
        // leftToMid(n-1);
        System.out.println("Move" + n + "from left to right");
        // midToRight(n-1);
    }

    public static void leftToMId(int n){
        if(n==1){
            System.out.println("Move 1 from left to mid");
            return;
        }
        leftToRight(n-1);
        System.out.println("Move"+n+"from left to mid");
        // rightToMid(n-1);

    }

    public static void rightToMid(int n){
        if(n==1){
            System.out.println();
        }
    }

}
