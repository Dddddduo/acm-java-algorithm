import java.io.*;
import java.util.*;

public class Main {
    static long MOD = 998244353;

    static class Node {
        int id;
        List<Node> children = new ArrayList<>();
        int height;
        long G; // f(u, C)
        long H; // f(u, infinity)

        // DP vector data
        ArrayList<Long> vec;
        long mul = 1;
        int offset = 0; // logical index 0 is at vec.get(offset)

        // Helper to get logical value at i
        long get(int i) {
            if (offset + i >= vec.size()) return 0;
            return vec.get(offset + i) * mul % MOD;
        }

        // Helper to add value at logical i
        void addVal(int i, long val) {
            int pos = offset + i;
            if (pos >= vec.size()) return;
            long current = vec.get(pos);
            // current_real = current * mul
            // new_real = current_real + val
            // new_stored = new_real * invMul = current + val * invMul
            long invMul = power(mul, MOD - 2);
            long term = val * invMul % MOD;
            vec.set(pos, (current + term) % MOD);
        }

        void append(long val) {
            // appending at logical end.
            long invMul = power(mul, MOD - 2);
            vec.add(val * invMul % MOD);
        }
    }

    static int N, K, C;
    static Node[] nodes;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");

        // Precompute factorials
        fact = new long[300005];
        fact[0] = 1;
        for(int i=1; i<fact.length; i++) fact[i] = fact[i-1] * i % MOD;

        String line;
        while ((line = next(br, st)) != null) {
            int t = Integer.parseInt(line);
            while(t-- > 0) {
                N = Integer.parseInt(next(br, st));
                K = Integer.parseInt(next(br, st));
                C = K - 2;

                nodes = new Node[N + 1];
                for(int i=1; i<=N; i++) {
                    nodes[i] = new Node();
                    nodes[i].id = i;
                }

                for(int i=2; i<=N; i++) {
                    int p = Integer.parseInt(next(br, st));
                    nodes[p].children.add(nodes[i]);
                }

                dfsHeight(nodes[1]);
                solve(nodes[1]);

                out.println(nodes[1].H);
            }
        }
        out.flush();
    }

    static String next(BufferedReader br, StringTokenizer st) throws IOException {
        while (!st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static void dfsHeight(Node u) {
        u.height = 0;
        for(Node v : u.children) {
            dfsHeight(v);
            u.height = Math.max(u.height, v.height + 1);
        }
    }

    static void solve(Node u) {
        // Leaf case
        if(u.children.isEmpty()) {
            u.G = (C >= 0) ? 1 : 0;
            u.H = 1;
            u.vec = new ArrayList<>();
            u.vec.add(u.G); // index 0
            u.mul = 1;
            u.offset = 0;
            return;
        }

        Node heavy = null;
        int zeroCount = 0;
        Node zeroNode = null;

        for(Node v : u.children) {
            solve(v);
            if(v.G == 0) {
                zeroCount++;
                zeroNode = v;
            }
        }

        int maxH = -1;
        for(Node v : u.children) {
            if(v.height > maxH) {
                maxH = v.height;
                heavy = v;
            } else if(v.height == maxH) {
                if(heavy.G == 0 && v.G != 0) heavy = v;
            }
        }

        long prodG = 1;
        for(Node v : u.children) {
            if(v.G != 0) prodG = prodG * v.G % MOD;
        }
        long commonFact = fact[u.children.size() - 1];

        // Calculate G_u
        long sumTerm = 0;
        if(zeroCount == 0) {
            for(Node v : u.children) {
                long v_val1 = getVecVal(v, 1);
                sumTerm = (sumTerm + v_val1 * power(v.G, MOD-2)) % MOD;
            }
            sumTerm = sumTerm * prodG % MOD;
        } else if(zeroCount == 1) {
            long v_val1 = getVecVal(zeroNode, 1);
            sumTerm = v_val1 * prodG % MOD;
        } else {
            sumTerm = 0;
        }
        u.G = commonFact * sumTerm % MOD;

        // Calculate H_u
        long sumHTerm = 0;
        if(zeroCount == 0) {
            for(Node v : u.children) {
                sumHTerm = (sumHTerm + v.H * power(v.G, MOD-2)) % MOD;
            }
            sumHTerm = sumHTerm * prodG % MOD;
        } else if(zeroCount == 1) {
            sumHTerm = zeroNode.H * prodG % MOD;
        } else {
            sumHTerm = 0;
        }
        u.H = commonFact * sumHTerm % MOD;

        // Construct vector for u
        if(zeroCount > 1) {
            u.vec = new ArrayList<>();
            for(int i=0; i<=u.height; i++) u.vec.add(0L);
            u.offset = 0;
            u.mul = 1;
        } else {
            if(zeroCount == 1) {
                heavy = zeroNode;
            }

            u.vec = heavy.vec;
            u.offset = heavy.offset;
            u.mul = heavy.mul;

            // Shift
            u.offset++;

            // Append virtual values
            while(u.vec.size() - u.offset <= u.height) {
                int idx_in_u = u.vec.size() - u.offset;
                long val = getVirtual(heavy, idx_in_u + 1);
                u.append(val);
            }

            long scale;
            if(zeroCount == 1) {
                scale = commonFact * prodG % MOD;
            } else {
                scale = commonFact * prodG % MOD * power(heavy.G, MOD-2) % MOD;
            }
            u.mul = u.mul * scale % MOD;

            if(zeroCount == 0) {
                for(Node v : u.children) {
                    if(v == heavy) continue;
                    long termScale = commonFact * prodG % MOD * power(v.G, MOD-2) % MOD;

                    int v_limit = v.vec.size() - v.offset;
                    for(int k=0; k<v_limit; k++) {
                        long val = v.get(k+1);
                        u.addVal(k, val * termScale % MOD);
                    }
                    int start = v_limit;
                    int end = Math.min(u.vec.size()-u.offset, C+1);
                    if(start < end) {
                        long add = termScale;
                        for(int k=start; k<end; k++) {
                            u.addVal(k, add);
                        }
                    }
                }
            }
        }
    }

    static long getVecVal(Node v, int idx) {
        if(idx < v.vec.size() - v.offset) return v.get(idx);
        return (idx <= C) ? 1 : 0;
    }

    static long getVirtual(Node v, int idx) {
        return (idx <= C) ? 1 : 0;
    }

    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}