import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static final long MOD = (long) (1e9+7);

    public static void solve() throws IOException {

        long n=sc.nextLong(); // N只宠物
        double p=1.0-sc.nextDouble(); // 没被感染的概率

        if(p==1){
            System.out.println("0");
            return;
        }

        if(p==0){
            System.out.println(n);
            return;
        }

        if(n==1){
            System.out.println("1");
            return;
        }

        double num=n+1; // 消耗的数目

        long k=0;
        for(int i=1;i<=n;i++) { // i个人一组 每组恰好有i只宠物

            double ans = 0; // 消耗的试剂

            double ans1 = 0; // 分成多少组

            if(n%i==0) {
                ans1=n/i*1.0;
            }else {
                continue;
            }

            // 先统一测试
            ans+=ans1;

            // 恰好分成ans1组 每组i个人

            // 全部是阴性的概率
            double quanbuyingxing=1.0;
            for (int i1 = 0; i1 < i; i1++) {
                quanbuyingxing*=p;
            }

            // 有阳性的概率
            double youyang=1.0-quanbuyingxing;

            // 有多少组阳性的
            double yangzu=youyang*ans1*1.0;

            // 分别测
            ans+=yangzu*i;

            if(ans<num){
                num=ans;
                k=i;
            }

        }

        System.out.println(k);

    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {solve();}
    }

}