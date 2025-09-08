import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = 998244353;
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long arr[]=new long[n];
            for (int i1 = 0; i1 < n; i1++) {
                arr[i1] = sc.nextLong();
            }
            long m=1;
            for (int i1 = 0; i1 < n - 1; i1++) {
                m*=2;
                m%=mod;
            }
            System.out.println(m);
        }
    }
}