import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        int n=sc.nextInt();
        int arr[]=new int[n+1];

        for (int i = 0; i < n-1; i++) {
            arr[sc.nextInt()] ++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
