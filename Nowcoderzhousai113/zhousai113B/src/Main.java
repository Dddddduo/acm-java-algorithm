import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long mod = 1000000007;
    private static void solve() {

        int n = sc.nextInt();
        long arr[][]=new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0]=sc.nextLong();
            arr[i][1]=sc.nextLong();
        }

        long x=arr[0][0];
        long y=arr[0][1];

        // a+b*i
        for (int i = 1; i < n; i++) {
            long tempx=x,tempy=y;
            x=arr[i][0]*tempx-arr[i][1]*tempy;
            y=arr[i][1]*tempx+arr[i][0]*tempy;
            if(x<0) x+=mod;
            if(y<0) y+=mod;
            x%=mod;
            y%=mod;
//             System.out.println(x+" "+y);
        }

        x%=mod;
        y%=mod;
        if(x<0) x+=mod;
        if(y<0) y+=mod;
        System.out.println(x+" "+y);

    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
