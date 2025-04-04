import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IOS sc=new IOS();
        int n=sc.nextInt();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int ans=sc.nextInt();
            max=Math.max(max,ans);
            min=Math.min(min,ans);
        }

        System.out.println( (max-min)+" "+( (max-min)%2!=0?(max+min)/2+1: (max+min)/2) );

    }
}


class IOS{
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;
    public IOS(){
        bf=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer("");
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public String nextLine() throws IOException {
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