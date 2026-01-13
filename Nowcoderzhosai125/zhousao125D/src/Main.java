import java.util.*;
import java.io.*;

public class Main {
    static IoScanner sc = new IoScanner();

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        String A = sc.next();
        String B = sc.next();

        int sumA = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') sumA ^= 1;
        }
        int sumB = 0;
        for (int i = 0; i < m; i++) {
            if (B.charAt(i) == '1') sumB ^= 1;
        }

        if (sumA != sumB) {
            sc.println("NO");
            return;
        }

        int curA = 0;
        int curB = 0;
        int ptr = 0;

        for (int i = 0; i < m - 1; i++) {
            if (B.charAt(i) == '1') curB ^= 1;
            boolean found = false;
            while (ptr < n - 1) {
                if (A.charAt(ptr) == '1') curA ^= 1;
                ptr++;
                if (curA == curB) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                sc.println("NO");
                return;
            }
        }
        sc.println("YES");
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.flush();
        sc.bw.close();
    }
}

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
            String line = bf.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public char nextChar() throws IOException {
        return next().charAt(0);
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public void println(int a) throws IOException {
        print(a);
        println();
    }

    public void print(int a) throws IOException {
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException {
        print(a);
        println();
    }

    public void print(String a) throws IOException {
        bw.write(a);
    }

    public void println() throws IOException {
        bw.newLine();
    }

    public void flush() throws IOException {
        bw.flush();
    }

    public void close() throws IOException {
        bw.close();
        bf.close();
    }
}