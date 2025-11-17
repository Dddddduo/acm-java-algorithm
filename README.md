# ACM Java Algorithm Repository 🚀

![Java](https://img.shields.io/badge/Java-17+-orange)
![Codeforces](https://img.shields.io/badge/Codeforces-1400-blue)
![NowCoder](https://img.shields.io/badge/牛客周赛-1700-red)
![LeetCode](https://img.shields.io/badge/LeetCode-Hot100%20全解-success)

**👨💻 开发者信息**  
`2024-2025赛季算法竞赛选手` | `Java后端开发者` | `已退役` | 

🏆 核心成就：
- 第十九届 CCPC 中国大学生程序设计竞赛全国邀请赛(东北) 铜牌
- 第十八届 CCPC 吉林省大学生程序设计竞赛A组 铜牌
- 第十九届 CCPC 东北地区大学生程序设计竞赛 铜牌
- 第16届蓝桥杯Java组 省赛一等奖 国赛二等奖 
- 第15届蓝桥杯Java组 省赛一等奖 国赛三等奖
- CCF编程能力认证 CACC全国前500名 国赛优秀奖
- Codeforces最高 rating 1500（ Specialist ）
- 牛客周赛 rating 1700
- LeetCode Hot100 全解
- LeetCode 常见SQL 全解
---

## 📦 仓库全景图

### 🌟 核心模块
| 模块类型         | 内容概要                          | 更新频率      |
|------------------|----------------------------------|-------------|
| 每日刷题         | LeetCode/Codeforces每日精选      | 每日更新✨    |
| 算法模板库       | 60+常用算法模板（含时空复杂度）   | 按周迭代     |
| 竞赛全记录       | Codeforces/牛客/蓝桥杯真题解析    | 赛后24h更新  |
| 校赛精选         | 清华/北大/浙大等Top高校赛题       | 不定期更新   |
| 实战技巧         | 输入输出优化/骗分技巧/调试策略     | 经验驱动更新 |

---

## 🛠️ 代码结构示例

```text
src/
├── daily-challenge        # 每日一题系列
│   ├── 20240520-leetcode215.java
│   └── 20240521-codeforces1923C.java
├── algorithm-templates    # 算法模板
│   ├── graph              # 图论
│   │   ├── Dijkstra.java
│   │   └── Tarjan.java
│   └── dp                 # 动态规划
│       ├── Knapsack.java
│       └── LIS.java
├── competition            # 竞赛实录
│   ├── codeforces         # Codeforces
│   │   ├── div2           # Div2完整赛题
│   │   └── div3           # Div3完整赛题
│   └── nowcoder           # 牛客竞赛
└── university             # 校赛精选
    ├── THU-2024A          # 清华大学校赛
    └── ZJU-2023B          # 浙江大学校赛
```

---

## Java算法模版

```java
// https://github.com/Dddddduo/acm-java-algorithm
// powed by Dduo
import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

// 多多世界第一可爱!
public class Main {

    static IoScanner sc = new IoScanner();
//    static final int mod = (int) (1e9 + 7);
//    static final int mod = (int) (998244353);

    static int n;
    static int arr[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    private static void solve() throws IOException {
      
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        t = sc.nextInt();
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

    public void println(int a) throws IOException{
        print(a);
        println();
    }

    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(String a) throws IOException{
        print(a);
        println();
    }

    public void print(String a) throws IOException{
        bw.write(a);
    }

    public void println(long a) throws IOException{
        print(a);
        println();
    }

    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(double a) throws IOException{
        print(a);
        println();
    }

    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void print(BigInteger a) throws IOException{
        bw.write(a.toString());
    }

    public void println(BigInteger a) throws IOException{
        bw.write(a.toString());
        println();
    }

    public void print(char a) throws IOException{
        bw.write(String.valueOf(a));
    }

    public void println(char a) throws IOException{
        print(a);
        println();
    }

    public void println() throws IOException{
        bw.newLine();
    }

    //其他调试命令：
    public void flush() throws IOException{
        //交互题分组调试，或者提前退出的情况下可以先运行此语句再推出
        bw.flush();
        return;
    }

    public boolean hasNext() throws IOException{
        //本地普通IDE难以使用这个方法调试，需要按照数据组flush，刷新语句:
        //sc.flush()
        //调试完可删去
        return bf.ready();
    }

}
```

---

## 🤝 共建指南
1. **Issue规范**：提交问题请注明平台（如CF1923D）和错误描述
2. **PR准则**：
    - 新增算法模板需包含时空复杂度分析
    - 竞赛代码需通过对应平台测试
3. 推荐贡献方向：
    - 补充Codeforces 1400+题解
    - 完善动态规划状态压缩模板
    - 校赛新颖题型的Java实现

---

## 📜 开源协议
MIT License © 2024 dduo  
允许自由使用/修改代码，**引用请注明出处**。商业使用请联系授权。

[![Star History Chart](https://api.star-history.com/svg?repos=Dddddduo/acm-java-algorithm&type=Date)](https://star-history.com/#Dddddduo/acm-java-algorithm&Date)
```

---

🔍 **快速导航**  
📌 [高频算法模板速查](src/algorithm-templates)  
🔥 [最新竞赛题解](src/competition)  
💡 [实战技巧手册](src/practical-skills)  

🚢 扬帆起航，算法之海任你遨游！
```
