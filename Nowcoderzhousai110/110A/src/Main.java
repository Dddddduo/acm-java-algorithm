import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {
        long n=sc.nextLong();
        if(n%2==0||n==3||n==5||n==9){
            System.out.println("YES");
        }else{
            System.out.println("NO");
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
