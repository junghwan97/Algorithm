import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        bw.write(bfs(N, K) + " ");
        bw.flush();
        bw.close();
    }

    static int bfs(int n, int k) {
        Deque<Integer> que = new LinkedList<>();
        int[] visited = new int[100001];

        que.add(n);
        visited[n] = 1;

        while (!que.isEmpty()) {
            int current = que.poll();
            if (current == k) {
                return visited[current] - 1;
            }
            // 세 가지 이동 경우 탐색
            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    que.offer(next); // 큐에 추가
                    visited[next] = visited[current] + 1; // 이동 시간 기록
                }
            }
        }
        return -1; // 도달 불가 (문제 조건상 발생하지 않음)
    }
}
