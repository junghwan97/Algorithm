import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령어의 개수
        Deque<Integer> que = new ArrayDeque<>(); // 정수를 저장하는 자료구조

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": // 정수를 큐에 넣는 연산
                    que.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop": // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력 / 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if (!que.isEmpty()) {
                        System.out.println(que.getFirst());
                        que.removeFirst();
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "size": // 큐에 들어있는 정수의 개수를 출력
                    System.out.println(que.size());
                    break;
                case "empty": // 큐가 비어있으면 1, 아니면 0을 출력
                    if (que.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front": // 큐의 가장 앞에 있는 정수를 출력 / 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                    if (!que.isEmpty()) {
                        System.out.println(que.getFirst());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "back": // 큐의 가장 뒤에 있는 정수를 출력 / 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                    if (!que.isEmpty()) {
                        System.out.println(que.getLast());
                    } else {
                        System.out.println("-1");
                    }
                    break;
            }

        }
    }
}
