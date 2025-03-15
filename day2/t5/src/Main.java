import java.io.*;
import java.math.*;
import java.util.*;
// https://ac.nowcoder.com/acm/contest/103151/C
public class Main {

    static IoScanner sc=new IoScanner();
    static int MOD=(int) (1e9+7);

    static void solve() throws IOException {

        int n = sc.nextInt();
        int q = sc.nextInt();

        // 读取字符串 s
        String s = sc.next();

        // 初始化 cnt 数组，用于记录每个字母的出现次数
        int[] cnt = new int[26];

        // 初始化 pos 数组，用于记录每个字母在不同排列中的位置
        int[] pos = new int[26];

        // 初始化 g 二维数组，用于记录字母对的相关信息
        long[][] g = new long[26][26];

        // 初始值
        long ans = 0;

        // 遍历字符串 s
        for (int i = 0; i < n; i++) {
            int currentCharIndex = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j > currentCharIndex) {
                    ans += cnt[j];
                }
                g[j][currentCharIndex] += cnt[j];
            }
            cnt[currentCharIndex]++;
        }
        // 处理 q 次查询
        for (int i = 0; i < q; i++) {
            String ss = sc.next();
            // 记录每个字母在排列 t 中的位置
            for (int j = 0; j < 26; j++) {
                pos[ss.charAt(j) - 'a'] = j;
            }
            long res = ans;
            // 遍历所有字母对
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < j; k++) {
                    if (pos[k] > pos[j]) {
                        res = res - g[j][k] + g[k][j];
                    }
                }
            }
            // 输出结果
            dduoln(res);

        }
    }


    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {solve();}
    }

    static <T> void dduo(T t) {System.out.print(t);}
    static <T> void dduoln(T t) {System.out.println(t);}
    static <T> void dduoln() {System.out.println("");}
}

class IoScanner{
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;
    public IoScanner(){
        bf=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer("");
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public String nextLine() throws IOException{
        return bf.readLine();
    }
    public String next() throws IOException{
        while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    public char nextChar() throws IOException{
        return next().charAt(0);
    }
    public int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    public long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    public float nextFloat() throws IOException{
        return Float.parseFloat(next());
    }
    public BigInteger nextBigInteger() throws IOException{
        return new BigInteger(next());
    }
    public BigDecimal nextDecimal() throws IOException{
        return new BigDecimal(next());
    }
}