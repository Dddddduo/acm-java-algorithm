import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        String str=sc.next();

        long cnt = 0;

        for(int i=0;i<str.length();i++) {
            cnt +=  (str.charAt(i)-'0') ;
        }

        System.out.println(cnt%9);

    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
