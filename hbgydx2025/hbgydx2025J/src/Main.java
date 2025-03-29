import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt();
            int s = a + b + c;
            if (s <= t) {
                courses.add(new  Course(s, t));
            }
        }
        courses.sort(Comparator.comparingInt(c  -> c.t));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (Course course : courses) {
            maxHeap.offer(course.s);
            sum += course.s;
            if (sum > course.t) {
                sum -= maxHeap.poll();
            }
        }
        System.out.println(maxHeap.size());
    }

    static class Course {
        int s, t;
        Course(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}