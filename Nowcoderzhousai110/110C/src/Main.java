import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {
        int n=sc.nextInt();
        long arr[]=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }
        long max=-1;
        int max_index=-1;
        for (int i = 0; i < n; i++) {
            if(arr[i]>max){
                max=arr[i];
                max_index=i;
            }
        }

        long ans=-1;

        // 左边
        if(max_index!=0){
            for (long i = 0; i <= max + 1; i++) {
                if(i!=arr[max_index]&&i!=arr[max_index-1]){
                    ans=Math.max(ans,max-i);
                    break;
                }
            }
        }

        // 右边
        if(max_index!=n-1){
            for (long i = 0; i <= max + 1; i++) {
                if(i!=arr[max_index]&&i!=arr[max_index+1]){
                    ans=Math.max(ans,max-i);
                    break;
                }
            }
        }

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
