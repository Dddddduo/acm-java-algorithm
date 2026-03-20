import java.io.*;
import java.util.*;

public class Main {

    static class Message implements Comparable<Message> {
        String content;
        int priority;
        int id;

        public Message(String content, int priority, int id) {
            this.content = content;
            this.priority = priority;
            this.id = id;
        }

        @Override
        public int compareTo(Message other) {
            if (this.priority != other.priority) {
                return other.priority - this.priority;
            }
            return this.id - other.id;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 初始化文件写入流（保存输入/输出到文件）
        PrintWriter inputFileWriter = new PrintWriter(new FileWriter("input.txt"));
        PrintWriter outputFileWriter = new PrintWriter(new FileWriter("output.txt"));

        // 2. 初始化控制台IO（OJ标准格式）
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter consoleOut = new PrintWriter(System.out);

        // ===== 读取并保存指令总数 =====
        String firstLine = br.readLine();
        int n = Integer.parseInt(firstLine);
        inputFileWriter.println(firstLine); // 写入input.txt

        // 核心存储结构
        Map<String, PriorityQueue<Message>> broker = new HashMap<>();
        int globalId = 0;

        for (int i = 0; i < n; i++) {
            // ===== 读取并保存单条指令 =====
            String line = br.readLine();
            inputFileWriter.println(line); // 写入input.txt

            StringTokenizer st = new StringTokenizer(line);
            String op = st.nextToken();

            if ("P".equals(op)) {
                // 生产消息：仅执行逻辑，无控制台输出
                String topic = st.nextToken();
                int priority = Integer.parseInt(st.nextToken());
                String content = st.nextToken();
                broker.computeIfAbsent(topic, k -> new PriorityQueue<>())
                        .offer(new Message(content, priority, ++globalId));

            } else if ("C".equals(op)) {
                // 消费消息：控制台+文件同时输出核心结果
                String topic = st.nextToken();
                PriorityQueue<Message> queue = broker.get(topic);
                String result = queue == null || queue.isEmpty() ? "NULL" : queue.poll().content;

                // 控制台输出（OJ格式）
                consoleOut.println(result);
                consoleOut.flush();
                // 写入output.txt
                outputFileWriter.println(result);
                outputFileWriter.flush();
            }
        }

        // ===== 关闭所有流 =====
        br.close();
        consoleOut.close();
        inputFileWriter.close();
        outputFileWriter.close();

        // 提示文件生成完成（可选，可删除）
        System.out.println("输入已保存到 input.txt，输出已保存到 output.txt");
    }
}