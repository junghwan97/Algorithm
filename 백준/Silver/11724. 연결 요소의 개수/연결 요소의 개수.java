import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 인접 리스트 초기화
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        
        visited = new boolean[N + 1];
        int count = 0;
        
        // 연결 요소 개수 세기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    // 깊이 우선 탐색(DFS)
    static void dfs(int node) {
        visited[node] = true;
        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
