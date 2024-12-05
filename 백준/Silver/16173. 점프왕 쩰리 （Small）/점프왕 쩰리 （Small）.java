import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1}, dy = {1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine()); // 게임판 크기
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(arr, N) ? "HaruHaru" : "Hing");

    }

    static boolean bfs(int[][] arr, int N) {


        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 시작점
        visited[0][0] = true; // 시작 위치 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 탐색 종료
            if (arr[x][y] == -1) return true; // 도착 지점 도달

            // 현재 칸에서 이동 가능한 거리
            int step = arr[x][y];

            // 방향 탐색 계산
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i] * step; // <= 3
                int ny = y + dy[i] * step;

                // 범위 및 방문 체크 ?  뭐 이런거
                if (nx < N && ny < N && !visited[nx][ny] && nx >= 0 && ny >= 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }

        }
        return false;
    }
}