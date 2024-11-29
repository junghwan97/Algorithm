import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙, 키 큰 순서대로 거인 정렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 거인 나라의 인구수
        int H = Integer.parseInt(st.nextToken()); // 센티의 키
        int T = Integer.parseInt(st.nextToken()); // 뿅망치 제한 횟수
        int count = 0; // 뿅망치 사용 횟수

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine())); // 거인 줄 세우기(키 큰 순)
        }
        while (true) {
            if (T == 0) {
                break;
            }
            if (H <= pq.peek() && pq.peek() != 1) {
                int magic = pq.poll() / 2;
                pq.offer(magic);
                T--;
                count++;
            } else {
                break;
            }
        }
        if (H > pq.peek()) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(pq.peek());
        }
    }
}
