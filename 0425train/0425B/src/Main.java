import java.math.*;
import java.util.*;

public class Main {
    private static void solve() throws Exception {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());
        BigInteger m = new BigInteger(sc.next());
        BigInteger k = new BigInteger(sc.next());

        BigInteger cnt = BigInteger.ZERO;

        for (BigInteger boy = BigInteger.valueOf(4);  boy.compareTo(n)  <= 0; boy = boy.add(BigInteger.ONE))  {
            BigInteger girl = k.subtract(boy);
//            System.out.println(girl);

            if (girl.compareTo(m.add(BigInteger.ONE))  >= 0) continue;
            if (girl.compareTo(BigInteger.ONE)  < 0) continue;

//            System.out.println("123");

            cnt = cnt.add(cn(n,  boy).multiply(cn(m, girl)));
        }

        System.out.println(cnt);
    }

    // 计算排列数 An(n, m) = n! / (n-m)!
    public static BigInteger an(BigInteger n, BigInteger m) {
        if (m.compareTo(BigInteger.ZERO)  < 0 || m.compareTo(n)  > 0) return BigInteger.ZERO;
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(m)  < 0; i = i.add(BigInteger.ONE))  {
            result = result.multiply(n.subtract(i));
        }
        return result;
    }

    // 计算组合数 Cn(n, m) = An(n, m) / m!
    public static BigInteger cn(BigInteger n, BigInteger m) {
        if (m.compareTo(BigInteger.ZERO)  < 0 || m.compareTo(n)  > 0) return BigInteger.ZERO;
        return an(n, m).divide(factorial(m));
    }

    // 计算阶乘（用于组合数分母）
    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO)  < 0) throw new IllegalArgumentException("n不能为负数");
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = new BigInteger("2"); i.compareTo(n)  <= 0; i = i.add(BigInteger.ONE))  {
            result = result.multiply(i);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        solve();
    }
}