import java.io.*;
import java.util.*;

public class Main {
    static int rows, cols;
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken()); // 목초지의 행
        cols = Integer.parseInt(st.nextToken()); // 목초지의 열

        field = new char[rows][cols]; // 목초지(2차원 배열) - 인접 행렬
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            field[i] = br.readLine().toCharArray(); // 한 줄씩 읽음
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (field[i][j] == '#' && !visited[i][j]) {
                    dfs(i, j, field[i][j]);
//                    bfs(i, j);
                    count++;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    // DFS 함수
    static void dfs(int r, int c, char type) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || field[r][c] != type || visited[r][c]) {
            return;
        }

        visited[r][c] = true; // 현재 위치 방문 처리

        // 풀 더미 탐색
        if (type == '#') {
            dfs(r, c + 1, type); // 오른쪽으로만 탐색
            dfs(r + 1, c, type); // 아래쪽으로만 탐색
        }
    }
}