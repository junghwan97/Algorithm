import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] kit;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(result);
    }

    // day: 지금까지 사용한 키트 수, weight: 현재 중량
    static void dfs(int day, int weight) {
        // 하루가 지날 때마다 근손실로 K만큼 감소하므로, 감소 후 체크
        if (day > 0 && weight < 500) {
            return;
        }
        // N일 동안 모두 키트 사용을 끝냈다면 경우의 수 하나 카운트
        if (day == N) {
            result++;
            return;
        }
        // 아직 사용하지 않은 키트 중 하나를 골라서 시도
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int newWeight = weight - K + kit[i];
                if (newWeight >= 500) {
                    visited[i] = true;
                    dfs(day + 1, newWeight);
                    visited[i] = false;
                }
            }
        }
    }
}
