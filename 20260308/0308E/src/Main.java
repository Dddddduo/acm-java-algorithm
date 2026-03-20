import java.math.BigInteger;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = 1;
//        t = sc.nextInt();
        多多世界第一可爱:
        for (int i1 = 0; i1 < t; i1++) {
            int n = sc.nextInt();
            int x= sc.nextInt();
            int y= sc.nextInt();

            long a[]=new long[n];
            long b[]=new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            for (int i = 0; i < n; i++) b[i] = sc.nextLong();

            BigInteger fenzi=BigInteger.valueOf(0);
            for (int i = 0; i < n; i++) {
                fenzi=fenzi.add(BigInteger.valueOf(a[i]).multiply(BigInteger.valueOf(b[i])));
            }

            BigInteger aSum=BigInteger.valueOf(0);
            for (int i = 0; i < n; i++) {
                aSum=aSum.add(BigInteger.valueOf(a[i]));
            }
            BigInteger aResult=BigInteger.valueOf(1);
            for (int i = 0; i < x; i++) {
                aResult=aResult.multiply(aSum);
            }

            BigInteger bSum=BigInteger.valueOf(0);
            for (int i = 0; i < n; i++) {
                bSum=bSum.add(BigInteger.valueOf(b[i]));
            }
            BigInteger bResult=BigInteger.valueOf(1);
            for (int i = 0; i < y; i++) {
                bResult=bResult.multiply(bSum);
            }

//            System.out.println(aResult+" "+bResult);

            BigInteger fenmu=aResult.add(bResult);

            BigInteger gcd = fenmu.gcd(fenzi);

            fenzi=fenzi.divide(gcd);
            fenmu=fenmu.divide(gcd);

            if(fenmu.equals(BigInteger.ONE)){
                System.out.println(fenzi);
                return;
            }
            System.out.println(fenzi+"/"+fenmu);

        }
    }
}