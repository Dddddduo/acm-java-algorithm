
// 组合数
public class Main {
    // 计算排列数 An(n, m) = n! / (n-m)!
    public static long an(int n, int m) {
        if (m < 0 || m > n) return 0;
        long result = 1;
        for (int i = 0; i < m; i++) {
            result *= (n - i);
            if (result < 0) { // 检测溢出
                throw new ArithmeticException("An计算溢出，n或m过大");
            }
        }
        return result;
    }

    // 计算组合数 Cn(n, m) = An(n, m) / m!
    public static long cn(int n, int m) {
        if (m < 0 || m > n) return 0;
        return an(n, m) / factorial(m);
    }

    // 计算阶乘（用于组合数分母）
    private static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n不能为负数");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            if (result < 0) { // 检测溢出
                throw new ArithmeticException("阶乘计算溢出，n过大");
            }
        }
        return result;
    }

    // 测试用例
    public static void main(String[] args) {
        System.out.println("C(5,2)  = " + cn(5, 2)); // 输出10
        System.out.println("A(5,2)  = " + an(5, 2)); // 输出20
        System.out.println("C(20,10)  = " + cn(20, 10)); // 输出184756
    }
}