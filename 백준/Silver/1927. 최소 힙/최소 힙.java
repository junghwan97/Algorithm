import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minQue = new PriorityQueue<>(); // 최소 힙
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine()); // 두 번째 줄 -> 자연수면 배열에 넣고 0이면 배열에서 가장 작은 값 출력 후 제거
            if (x > 0) minQue.offer(x);
            else if (x == 0) {
                if (minQue.peek() == null) bw.write("0\n");
                else bw.write(minQue.peek()+"\n"); // 가장 작은 수 출력
                minQue.poll(); // 가장 작은 수 제거
            }
        }
        bw.flush();
        bw.close();
    }
}
