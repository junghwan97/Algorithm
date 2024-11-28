import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령어의 개수
        Deque<Integer> stack = new ArrayDeque<>(); // 정수를 저장하는 자료구조

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": // 정수를 스택에 넣는 연산
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop": // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력 / 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (!stack.isEmpty()) {
                        System.out.println(stack.getLast());
                        stack.removeLast();
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "size": // 스택에 들어있는 정수의 개수를 출력
                    System.out.println(stack.size());
                    break;
                case "empty": // 스택이 비어있으면 1, 아니면 0을 출력
                    if (stack.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "top": // 스택의 가장 위에 있는 정수를 출력 / 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                    if (!stack.isEmpty()) {
                        System.out.println(stack.getLast());
                    } else {
                        System.out.println("-1");
                    }
                    break;
            }
        }
    }
}

