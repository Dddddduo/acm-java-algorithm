import java.awt.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;
//        t=sc.nextInt();
        for (int i1 = 0; i1 < t; i1++) {
            String str = sc.next();
            int a=0;
            int ab=0;
            int cnt=0;
            for (char c : str.toCharArray()) {
                if(c=='A')a++;
                if(c=='B'&&a>0){
                    a--;
                    ab++;
                }
                if(c=='C'&&ab>0){
                    ab--;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}