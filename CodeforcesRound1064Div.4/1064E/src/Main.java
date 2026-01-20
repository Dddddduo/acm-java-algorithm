import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> dataList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            dataList.add(st.nextToken());
        }
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                dataList.add(st.nextToken());
            }
        }
        int ptr = 0;
        if (ptr >= dataList.size()) return;
        int t = Integer.parseInt(dataList.get(ptr++));
        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = Integer.parseInt(dataList.get(ptr++));
            int m = Integer.parseInt(dataList.get(ptr++));
            int k = Integer.parseInt(dataList.get(ptr++));
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(dataList.get(ptr++));
            }
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(dataList.get(ptr++));
            }
            String gdCode = dataList.get(ptr++);
            Arrays.sort(a);
            Arrays.sort(b);
            List<Integer>[] bucketsX = new List[k + 2];
            List<Integer>[] bucketsY = new List[k + 2];
            for (int i = 0; i <= k + 1; i++) {
                bucketsX[i] = new ArrayList<>();
                bucketsY[i] = new ArrayList<>();
            }
            int j = 0;
            int[] dRList = new int[n];
            int[] dLList = new int[n];
            for (int i = 0; i < n; i++) {
                int pos = a[i];
                while (j < m && b[j] < pos) {
                    j++;
                }
                if (j < m) {
                    int dist = b[j] - pos;
                    dRList[i] = dist > k ? k + 1 : dist;
                } else {
                    dRList[i] = k + 1;
                }
                if (j > 0) {
                    int dist = pos - b[j - 1];
                    dLList[i] = dist > k ? k + 1 : dist;
                } else {
                    dLList[i] = k + 1;
                }
            }
            for (int i = 0; i < n; i++) {
                int dr = dRList[i];
                int dl = dLList[i];
                if (dr <= k) {
                    bucketsX[dr].add(i);
                }
                if (dl <= k) {
                    bucketsY[dl].add(i);
                }
            }
            boolean[] dead = new boolean[n];
            int aliveCount = n;
            int curP = 0;
            int minP = 0;
            int maxP = 0;
            int curX = 0;
            int curY = 0;
            StringBuilder resSb = new StringBuilder();
            for (char c : gdCode.toCharArray()) {
                if (c == 'L') {
                    curP--;
                } else {
                    curP++;
                }
                if (curP < minP) {
                    minP = curP;
                    int newY = -minP;
                    if (newY > curY) {
                        if (newY <= k) {
                            for (int idx : bucketsY[newY]) {
                                if (!dead[idx]) {
                                    dead[idx] = true;
                                    aliveCount--;
                                }
                            }
                        }
                        curY = newY;
                    }
                }
                if (curP > maxP) {
                    maxP = curP;
                    int newX = maxP;
                    if (newX > curX) {
                        if (newX <= k) {
                            for (int idx : bucketsX[newX]) {
                                if (!dead[idx]) {
                                    dead[idx] = true;
                                    aliveCount--;
                                }
                            }
                        }
                        curX = newX;
                    }
                }
                resSb.append(aliveCount).append(" ");
            }
            sb.append(resSb.toString().trim()).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}