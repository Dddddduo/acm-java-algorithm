import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String l = br.readLine();
                    if(l==null)return null;
                    st = new StringTokenizer(l);
                } catch (IOException e) {return null;}
            }
            return st.nextToken();
        }
        int nextInt() {
            String s=next();
            if(s==null)return -1;
            return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        String s = fs.next();
        if(s==null)return;
        int t = Integer.parseInt(s);
        while(t-->0){
            int n = fs.nextInt(),q=fs.nextInt();
            int m = 1<<n;
            int[] a = new int[m];
            int[] p = new int[m+1];
            p[0]=0;
            for(int i=0;i<m;i++){
                a[i]=fs.nextInt();
                p[i+1]=p[i]^a[i];
            }
            for(int i=0;i<q;i++){
                int b=fs.nextInt(),c=fs.nextInt();
                int x = b-1;
                int ov = a[x];
                int d = ov^c;
                int ans=0;
                for(int k=1;k<=n;k++){
                    int z=1<<(k-1);
                    int bl=x/z;
                    boolean f=bl%2==0;
                    int ms,ss;
                    if(f){
                        int ml=bl*z,mr=ml+z;
                        ms=(p[mr]^p[ml])^d;
                        int sl=mr,sr=sl+z;
                        ss=p[sr]^p[sl];
                        if(ms<ss)ans+=z;
                    }else{
                        int ml=bl*z,mr=ml+z;
                        ms=(p[mr]^p[ml])^d;
                        int sr=ml,sl=sr-z;
                        ss=p[sr]^p[sl];
                        if(ss>=ms)ans+=z;
                    }
                }
                out.println(ans);
            }
        }
        out.flush();
    }
}