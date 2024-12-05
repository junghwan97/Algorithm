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
                    bfs(i, j);
                    count++;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (field[nx][ny] == '#' && !visited[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
