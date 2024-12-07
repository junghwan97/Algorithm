import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] order;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 처리
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 주어진 문제 조건에 따라 오름차순 정렬
        for (int i = 0; i < N; i++) {
            Collections.sort(graph.get(i));
        }
        visited = new boolean[N + 1];
        order = new int[N + 1];

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(order[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

