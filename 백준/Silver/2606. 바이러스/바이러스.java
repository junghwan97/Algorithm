import java.io.*;
import java.util.*;

public class Main {
    static int n; // 모든 컴퓨터의 수
    static List<ArrayList<Integer>> network = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 모든 컴퓨터의 수 초기화
        int edge = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        for (int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) { // 주어진 간선 리스트로 인접 리스트 구성
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 처리
            network.get(a).add(b);
            network.get(b).add(a);
        }
        visited = new boolean[n+1]; // 방문 횟수 처리 초기화

        dfs(1);
        bw.write(count + " ");
        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int next : network.get(start)) {
            if (!visited[next]) {
                dfs(next);
                count++;
            }

        }
    }
}
