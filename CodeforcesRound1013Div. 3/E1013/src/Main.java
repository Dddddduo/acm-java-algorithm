import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);

    static List<Integer>list;

    public static void main(String[] args) {
        int t=1;
//        t=sc.nextInt();
//        list= generatePrimes(10000005);
        while (t-->0){
            solve();
        }
    }

    static void solve() {

//        int n=sc.nextInt();
//        for(int b=n;b>=1;b--){
//            for(int a=b-1;a>=1;a--){
//                if(isPrime(lcm(a,b)/gcd(a,b))){
//                    System.out.println(b+" "+a);
//                }
//            }
//        }

//        for(int i=0;i<=1e7;i++){
//            if(isPrime(i)){
//                System.out.println(i);
//            }
//        }
//
//        int prime[]=new int[]{};

        int cnt=0;
        int tt=sc.nextInt();

        // 查询
        for (int i = 0; i < tt; i++) {
            int ans=sc.nextInt();
            System.out.println(countPairs(ans));
        }

    }

    public static int countPairs(int n) {
        if (n < 2) {
            return 0;
        }

        // 埃拉托斯特尼筛
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n);  i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int total = 0;
        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {
                total += n / p;
            }
        }

        return total;
    }

    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (long i = 3; i <= Math.sqrt(number);  i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
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