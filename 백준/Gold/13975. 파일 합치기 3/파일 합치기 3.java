import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 최소 힙
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken())); // 각 장의 페이지 수
            }
            long total = 0;
            while (pq.size() > 1) {
                long file1 = pq.poll(); // 가장 작은 페이지
                long file2 = pq.poll(); // 가장 작은 페이지
                long plus = file1 + file2; // 가장 작은 페이지들끼리 더한 값
                total += plus;
                pq.offer(plus); // 가장 작은 페이지들끼리 더한 값을 다시 큐에 넣기
            }
            bw.write(total + "\n");
        }
        bw.flush();
        bw.close();
    }
}