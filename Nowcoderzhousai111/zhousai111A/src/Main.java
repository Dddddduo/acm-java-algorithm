import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        if( (a+1)==b && (b+1)==c ){
            System.out.println("Yes");
        }else{
            System.out.println("No");
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
