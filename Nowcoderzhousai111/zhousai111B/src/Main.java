import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        int n=sc.nextInt();

        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int b[]=new int[n];
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }

        int min=Integer.MAX_VALUE;
        int temp_a=0;
        int temp_b=0;

        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                int num_a=a[i];
                int num_b=b[i1];
                if(num_a-num_b<min){
                    min=num_a-num_b;
                    temp_a=i+1;
                    temp_b=i1+1;
                }
            }
        }
        System.out.println(temp_a+" "+temp_b);

    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
