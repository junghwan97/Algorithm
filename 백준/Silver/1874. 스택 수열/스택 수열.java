import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int current = 1;  // 다음에 스택에 넣을 숫자
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // target이 나올 때까지 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택 최상단이 target인지 확인 후 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 불가능한 경우
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb.toString());
    }
}
