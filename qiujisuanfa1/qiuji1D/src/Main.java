import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void solve() {

        int n = sc.nextInt();
        int k = sc.nextInt();
        String str=sc.next();

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for(int i=0;i<26;i++){
            hm.put(i,new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            int index=c-'a';
            hm.get(index).add(i);
//             System.out.println(c+" "+i);
        }

        long min = Long.MAX_VALUE;

        for (Integer i : hm.keySet()) {
            ArrayList<Integer> list = hm.get(i);
//            System.out.println(list.size());
            if (list.size() < k) continue;
            for (int j = 0; j+k-1<list.size() ; j++) {
//                System.out.println( list.get(j+k-1)+" "+list.get(j) );
                min = Math.min(min, list.get(j+k-1)-list.get(j)+1);
            }
        }

        if(min==Long.MAX_VALUE){
            System.out.println("-1");
        }else {
            System.out.println(min);
        }

    }

    public static void main(String[] args) {
        int t = 1;
//        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
