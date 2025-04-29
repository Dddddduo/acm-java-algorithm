import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // 快速幂模板
    public static long fastPowerMod(long base, long exponent, long mod) {
        long result = 1 % mod;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) != 0) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }


}