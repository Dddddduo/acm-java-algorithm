import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static IoScanner sc = new IoScanner();
    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    public static void test1() throws IOException {
        dduoln("请输入一个字符串: ");
        String str = sc.nextLine();
        dduoln("请输入要查找的字符: ··");
        char targetChar = sc.next().charAt(0);

        long count = IntStream.range(0,  str.length())
                .mapToObj(str::charAt)
                .filter(c -> c == targetChar)
                .count();

        dduoln("\""  + str + "\"中包含" + count + "个\"" + targetChar + "\"。");
    }


    public static void test2(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        // 获取星期（1=星期日, 2=星期一, ..., 7=星期六）
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 转换为中文星期
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        System.out.println(" 今天是：" + weeks[dayOfWeek - 1]);
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