// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

// 食堂

// xixi♡西
public class Main {

    static Scanner sc = new Scanner(System.in);
    static final int mod = (int) (1e9 + 7);


    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int a2=sc.nextInt();
        int a3=sc.nextInt();
        int a4=sc.nextInt();
        int b4=sc.nextInt();
        int b6=sc.nextInt();

        int ans = 0;

        while (b6 > 0) { // 3+3
            if (a3 >= 2) {
                b6--;
                a3 -= 2;
                ans += 6;
            } else {
                break;
            }
        }

        while (b6 > 0) { // 4+2
            if (a4 > 0 && a2 > 0) {
                b6--;
                a4--;
                a2--;
                ans += 6;
            } else {
                break;
            }
        }

        while (b6 > 0) { // 2+2+2
            if (a2 >= 3) {
                b6--;
                a2 -= 3;
                ans += 6;
            } else {
                break;
            }
        }

        while (b6 > 0) { // 3+2
            if (a3 > 0 && a2 > 0) {
                b6--;
                a3--;
                a2--;
                ans += 5;
            } else {
                break;
            }
        }

        while (b6 > 0) { // 4
            if (a4 > 0) {
                b6--;
                a4--;
                ans += 4;
            } else {
                break;
            }
        }

        if (b6 > 0 && a2 == 2) { // 2+2
            ans += 4;
            b6--;
            a2 = 0;
        }
        if (b6 > 0 && a3 > 0) { // 3
            ans += 3;
            b6--;
            a3 = 0;
        }
        if (b6 > 0 && a2 > 0) { // 2
            ans += 2;
            a2 = 0;
        }

        while (b4 > 0) { // 4
            if (a4 > 0) {
                b4--;
                a4--;
                ans += 4;
            } else {
                break;
            }
        }

        while (b4 > 0) { // 2+2
            if (a2 >= 2) {
                b4--;
                a2 -= 2;
                ans += 4;
            } else {
                break;
            }
        }

        while (b4 > 0) { // 3
            if (a3 > 0) {
                b4--;
                a3--;
                ans += 3;
            } else {
                break;
            }
        }

        if (b4 > 0 && a2 > 0) { // 2
            ans += 2;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

}