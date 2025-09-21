import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {
        int n=sc.nextInt();
        long arr[]=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
        long ans=0;
        for (int i = 2; i < n; i++) {
            ans+=arr[i]*2;
        }
        ans+=arr[0];
        ans+=arr[1];
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
