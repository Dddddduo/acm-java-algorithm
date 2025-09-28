import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        long n=sc.nextLong();
        long k=sc.nextLong();

       if( k-(n-1)%2 == 0){
           for (long i = 0; i < n; i++) {
               System.out.print(1+" ");
           }
           System.out.println( (k-(n-1))/2);
           return;
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
