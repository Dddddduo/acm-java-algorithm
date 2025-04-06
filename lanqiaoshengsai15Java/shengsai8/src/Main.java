import java.io.*;
import java.math.*;
import java.util.*;

class Pair {
    long l;
    long w;
    Pair(long l, long w) {
        this.l = l;
        this.w = w;
    }
}

// 拼十字
public class Main {

    static Scanner sc = new Scanner(System.in);
    static final long MOD = (long) (1e9+7);

    static class Pair{
        // 长
        long l;
        // 宽
        long w;
        // 带参构造
        Pair(long ll,long ww){
            this.l=ll;
            this.w=ww;
        }
    }

    public static void solve() throws IOException {

        int n = sc.nextInt();

        // 分别存储颜色为 0、1、2 的矩形
        ArrayList<Pair> list0 = new ArrayList<>();
        ArrayList<Pair> list1 = new ArrayList<>();
        ArrayList<Pair> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long l = sc.nextLong();
            long w = sc.nextLong();
            long c = sc.nextLong();
            if (c == 0) {
                list0.add(new  Pair(l, w));
            } else if (c == 1) {
                list1.add(new  Pair(l, w));
            } else {
                list2.add(new  Pair(l, w));
            }
        }

        Collections.sort(list0,  Comparator.comparingLong(p  -> p.l));
        Collections.sort(list1,  Comparator.comparingLong(p  -> p.l));
        Collections.sort(list2,  Comparator.comparingLong(p  -> p.l));

        long cnt = 0;
        cnt += countPairs(list0, list1);
        cnt += countPairs(list1, list2);
        cnt += countPairs(list0, list2);

        System.out.print(cnt);

    }

    public static long countPairs(ArrayList<Pair> list1, ArrayList<Pair> list2) {
        long count = 0;
        for (Pair p1 : list1) {
            long l1 = p1.l;
            long w1 = p1.w;
            int left = 0, right = list2.size()  - 1;
            int lowerBound = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list2.get(mid).l  < l1) {
                    lowerBound = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            for (int i = 0; i <= lowerBound; i++) {
                if (list2.get(i).w  > w1) {
                    count++;
                }
            }
            left = 0;
            right = list2.size()  - 1;
            int upperBound = list2.size();
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list2.get(mid).l  > l1) {
                    upperBound = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int i = upperBound; i < list2.size();  i++) {
                if (list2.get(i).w  < w1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
//        t = sc.nextInt();
        while (t-- > 0) {solve();}
    }

}