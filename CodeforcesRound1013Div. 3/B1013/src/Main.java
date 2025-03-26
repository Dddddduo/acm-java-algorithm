import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int t=1;
        t=sc.nextInt();
        while (t-->0){
            solve();
        }
    }

    static void solve() {
        int n=sc.nextInt();
        long x=sc.nextLong();
        long arr[]=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
        int cnt=0;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=x){
                cnt++;
            }else{
                ans++;
                if(ans*arr[i]>=x){
                    cnt++;
                    ans=0;
                }
            }
        }
        System.out.println(cnt);
    }

}