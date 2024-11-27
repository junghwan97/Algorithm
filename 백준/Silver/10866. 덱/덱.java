import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 명령어의 수
        Deque<Integer> deque = new ArrayDeque<>(); // 정수를 담을 자료구조
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) { // 각 명령어 분기 처리
                case "push_front": //정수 덱의 앞에 넣는다.
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back": // 정수 덱의 뒤에 넣는다.
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front": // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력. 덱에 정수가 없는 경우에는 -1을 출력
                    if (!deque.isEmpty()) {
                        bw.write(deque.getFirst()+"\n");
                        deque.removeFirst();
                    } else bw.write("-1\n");
                    break;
                case "pop_back": // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력. 덱에 정수가 없는 경우에는 -1을 출력
                    if (!deque.isEmpty()) {
                        bw.write((deque.getLast())+"\n");
                        deque.removeLast();
                    } else bw.write("-1\n");
                    break;
                case "size": // 덱에 들어있는 정수의 개수를 출력
                    bw.write((Integer)deque.size()+"\n");
                    break;
                case "empty": // 덱이 비어있으면 1을, 아니면 0을 출력
                    if (deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front": // 덱의 가장 앞에 있는 정수를 출력. 덱에 정수가 없는 경우에는 -1을 출력
                    if (!deque.isEmpty()) bw.write(deque.getFirst()+"\n");
                    else bw.write("-1\n");
                    break;
                case "back": // 덱의 가장 뒤에 있는 정수를 출력. 덱에 정수가 없는 경우에는 -1을 출력
                    if (!deque.isEmpty()) bw.write(deque.getLast()+"\n");
                    else bw.write("-1\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}