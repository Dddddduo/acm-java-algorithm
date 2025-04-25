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
     *
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
            int n=sc.nextInt();
            ArrayList<String>list=new ArrayList<>();
            if(n==1){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 1; i++) {
                    sb.append(get(i));
                    list.add(sb.toString());
                    sb=new StringBuilder();
                }
            }
            if(n==2){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 2; i++) {
                    for (int i1 = 0; i1 < 2; i1++) {
                        if(get(i)!=get(i1)){
    
                        }else {
                            continue;
                        }
                        sb.append(get(i));
                        sb.append(get(i1));
                        list.add(sb.toString());
                        sb=new StringBuilder();
                    }
                }
            }
            if(n==3){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    for (int i1 = 0; i1 < 3; i1++) {
                        for (int i2 = 0; i2 < 3; i2++) {
                            if(get(i)!=get(i1)&&get(i)!=get(i2)&&get(i1)!=get(i2)){
    
                            }else {
                                continue;
                            }
                            sb.append(get(i));
                            sb.append(get(i1));
                            sb.append(get(i2));
                            list.add(sb.toString());
                            sb=new StringBuilder();
                        }
                    }
                }
            }
            if(n==4){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    for (int i1 = 0; i1 < 4; i1++) {
                        for (int i2 = 0; i2 < 4; i2++) {
                            for (int i3 = 0; i3 < 4; i3++) {
                                if(get(i)!=get(i1)&&get(i)!=get(i2)&&get(i)!=get(i3)&&get(i1)!=get(i2)&&get(i1)!=get(i3)&&get(i2)!=get(i3)){
    
                                }else {
                                    continue;
                                }
                                sb.append(get(i));
                                sb.append(get(i1));
                                sb.append(get(i2));
                                sb.append(get(i3));
                                list.add(sb.toString());
                                sb=new StringBuilder();
                            }
                        }
                    }
                }
            }
    
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                int length = list.get(i).length();
                for (int i1 = 0; i1 < length; i1++) {
                    if(i1==length-1){
                        dduo(list.get(i).charAt(i1)+" ");
                    }else {
                        dduo(list.get(i).charAt(i1)+"+");
                    }
                }
                dduoln("Problem");
            }
    
    
        }
    
        public static char get(int i){
            if(i==0)return 'A';
            if(i==1)return 'B';
            if(i==2)return 'C';
            if(i==3)return 'D';
            return 'E';
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