import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용해서 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer를 이용하여 BufferedReader의 readLine() 메소드로 읽어온 문자열을 토큰화 한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
        // 리스트로 선언한 그래프에 반복문을 통해 값을 넣어준다.
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 거리를 -1로 초기화
        distance[x] = 0; // 출발 도시의 거리는 0으로 설정
        Queue<Integer> queue = new LinkedList<>(); // 큐를 선언하고 , 넣어준다.
        queue.add(x);
        while (!queue.isEmpty()) {  // 큐가 비어있지 않을 때
            int current = queue.poll();
            for (int next : graph[current]) {
                if (distance[next] == -1) { // 방문하지 않은 도시라면
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}
