import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        int maxCount = 0;
        int lastStudent = Integer.MAX_VALUE;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.addLast(student);

                if (queue.size() > maxCount) {
                    maxCount = queue.size();
                    lastStudent = student;
                } else if (queue.size() == maxCount) {
                    lastStudent = Math.min(lastStudent, student);
                }
            } else if (command == 2) {
                queue.pollFirst();
            }
        }

        System.out.println(maxCount + " " + lastStudent);
    }
}