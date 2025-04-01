// @github https://github.com/Dddddduo
// @github https://github.com/Dddddduo/acm-java-algorithm
// @github https://github.com/Dddddduo/Dduo-mini-data_structure
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;
import java.time.*;

/**
 * 题目地址
 * https://ac.nowcoder.com/acm/contest/104956/F
 */

// xixi♡西
public class Main {

    static IoScanner sc = new IoScanner();
    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (1e9 + 7);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    /**
     * @throws IOException
     */
    private static void solve() throws IOException {
        // todo
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 存储队伍信息
        List<String[]> teams = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            teams.add(parts);
        }

        // 可以分配B类的学校
        n=sc.nextInt();
        Set<String> B_schools = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str=sc.next();
            B_schools.add(str);
        }

        // 可以分配C类的学校
        n=sc.nextInt();
        Set<String> C_schools = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str=sc.next();
            C_schools.add(str);
        }

//        for (String bSchool : B_schools) {
//            dduoln(bSchool);
//        }
//
//        System.out.println();
//
//        for (String cSchool : C_schools) {
//            dduoln(cSchool);
//        }

        // 计算各类名额
        int a_num = m * 6 / 10;
        int b_num = m * 3 / 10;
        int c_num = m / 10;

//        dduoln(a_num+" "+b_num+" "+c_num);

        // 统计每个学校的入选队伍数量
        Map<String, Integer> school_counts = new HashMap<>();

        // 做出非零贡献的学校
        Set<String> selected = new HashSet<>();

        List<String[]> A = new ArrayList<>();
        List<String[]> B = new ArrayList<>();
        List<String[]> C = new ArrayList<>();

        for (String[] team : teams) {
            String name=team[0];
            if(a_num==0&&b_num==0&&c_num==0){
                break;
            }
            if(a_num>0){
                if(school_counts.containsKey(name)&&school_counts.get(name)==3){
//                    continue;
                }else {
                    // 放到A里面
                    A.add(team);
                    school_counts.put(name,school_counts.getOrDefault(name,0)+1);
                    // 标记 表示已经选过了
                    selected.add(name);
                    a_num--;
                    continue;
                }
            }
            if(b_num>0&&B_schools.contains(name)){
//                System.out.println(team[2]);
//                System.out.println(school_counts.get(name));
//                System.out.println(selected.contains(name));
                if(school_counts.containsKey(name)&&school_counts.get(name)==3){
//                    dduoln(team[2]);
//                    continue;
                } else {
                    B.add(team);
                    school_counts.put(name,school_counts.getOrDefault(name,0)+1);
                    // 标记 表示已经选过了
                    selected.add(name);
                    b_num--;
                    continue;
                }
            }
            if(c_num>0&&C_schools.contains(name)){
                if(school_counts.containsKey(name)&&school_counts.get(name)==3){
//                    continue;
                } else {
                    C.add(team);
                    school_counts.put(name,school_counts.getOrDefault(name,0)+1);
                    // 标记 表示已经选过了
                    selected.add(name);
                    c_num--;
                    continue;
                }
            }
        }

        // 结果输出
        dduoln(A.size());
        for (String[] team : A) {
            dduoln(team[0]  + " " + team[1] + " " + team[2]);
        }
        dduoln(B.size());
        for (String[] team : B) {
            dduoln(team[0]  + " " + team[1] + " " + team[2]);
        }
        dduoln(C.size());
        for (String[] team : C) {
            dduoln(team[0]  + " " + team[1] + " " + team[2]);
        }
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static <T> void dduo(T t) {
        System.out.print(t);
    }

    static <T> void dduoln() {
        System.out.println("");
    }

    static <T> void dduoln(T t) {
        System.out.println(t);
    }
}

/**
 * IoScanner类
 *
 * @author Dduo
 * @version 1.0
 * @description 通过IO流操作缓冲区减少了与底层输入输出设备的交互次数，旨在简化 Java 中的标准输入读取操作。
 */
class IoScanner {
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;

    public IoScanner() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public String nextLine() throws IOException {
        return bf.readLine();
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    public char nextChar() throws IOException {
        return next().charAt(0);
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public float nextFloat() throws IOException {
        return Float.parseFloat(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    public BigDecimal nextDecimal() throws IOException {
        return new BigDecimal(next());
    }
}