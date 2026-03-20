import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long MOD = 1000000007;
    public static void main(String[] args) {
        int t = 1;
//        t = sc.nextInt();
        多多世界第一可爱:
        for (int i1 = 0; i1 < t; i1++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            String str1=sc.next();
            String str2=sc.next();
            int suf[][]=new int[26][n+1];
            ArrayList<ArrayList<Integer>> list=new ArrayList<>();
            for(int i=0;i<26;i++){
                list.add(new ArrayList<>());
                char c=(char) (i+'a');
                list.get(c).add(i);
                for (int i2 = n-1; i2 >=0; i2--) {
                    if(str1.charAt(i2)==c)suf[i][i2]++;
                    suf[i][i2]+=suf[i][i2+1];
                }
            }
//            for(int i=0;i<26;i++){
//                for (int i11 = 0; i11 < n+1; i11++) {
//                    System.out.print(suf[i][i11]+" ");
//                }
//                System.out.println();
//            }
            for (Integer i : list.get(str1.charAt(0))) {

            }
        }
    }
}