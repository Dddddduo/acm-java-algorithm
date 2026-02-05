import java.io.*;
import java.util.*;

public class Main {

    // 定义消息类，实现 Comparable 接口以支持 PriorityQueue 自动排序
    static class Message implements Comparable<Message> {
        String content;
        int priority;
        int id; // 逻辑时钟，用于保证同优先级下的 FIFO

        public Message(String content, int priority, int id) {
            this.content = content;
            this.priority = priority;
            this.id = id;
        }

        @Override
        public int compareTo(Message other) {
            // 1. 优先级高的排在前面 (降序)
            // Java 默认是升序 (this - other)，如果要降序则用 (other - this)
            if (this.priority != other.priority) {
                return other.priority - this.priority;
            }
            // 2. 优先级相同时，ID 小的（先来的）排在前面 (升序)
            return this.id - other.id;
        }
    }

    public static void main(String[] args) throws IOException {
        // 使用 BufferedReader 和 StringTokenizer 提高输入效率
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 使用 PrintWriter 提高输出效率
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 核心存储结构：Topic -> PriorityQueue
        Map<String, PriorityQueue<Message>> broker = new HashMap<>();

        // 全局自增 ID，模拟消息到达的时间戳
        int globalId = 0;

        for (int i = 0; i < n; i++) {
            // 读取每一行的指令
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);

            String op = st.nextToken();

            if ("P".equals(op)) {
                // --- 生产消息 ---
                String topic = st.nextToken();
                int priority = Integer.parseInt(st.nextToken());
                String content = st.nextToken();

                // 如果 Topic 不存在，创建一个新的优先队列
                // computeIfAbsent 是 Java 8 的高效写法
                broker.computeIfAbsent(topic, k -> new PriorityQueue<>())
                        .offer(new Message(content, priority, ++globalId));

            } else if ("C".equals(op)) {
                // --- 消费消息 ---
                String topic = st.nextToken();

                // 获取对应 Topic 的队列
                PriorityQueue<Message> queue = broker.get(topic);

                // 判断队列是否存在且不为空
                if (queue == null || queue.isEmpty()) {
                    out.println("NULL");
                } else {
                    // 取出堆顶元素（优先级最高 -> ID最小）
                    Message msg = queue.poll();
                    out.println(msg.content);
                }
            }
        }

        // 刷新缓冲区，确保所有输出都被打印
        out.flush();
        out.close();
        br.close();
    }
}