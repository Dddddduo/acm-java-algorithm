public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    // 计算两个数的最大公约数
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 计算两个数的最小公倍数
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

}