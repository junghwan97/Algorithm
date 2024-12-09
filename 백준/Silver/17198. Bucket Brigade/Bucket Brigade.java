import java.io.*;
import java.util.*;

public class Main {

    static char[][] farm = new char[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) { // 주어진 농장 입력
            String st = br.readLine();
            for (int j = 0; j < 10; j++) {
                farm[i][j] = st.charAt(j);
                if (farm[i][j] == 'L') start = new int[]{i, j}; // 호수를 출발지로 설정
                else if (farm[i][j] == 'B') end = new int[]{i, j}; // 헛간을 목적지로 설정
            }
        }

        int count = bfs();
        bw.write(count - 1 + " ");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Deque<int[]> que = new LinkedList<>();
        que.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] current = que.poll();
            int a = current[0];
            int b = current[1];
            int count = current[2];

            if (a == end[0] && b == end[1]) return count;

            for (int j = 0; j < 4; j++) {
                int nx = a + dx[j];
                int ny = b + dy[j];
                if (isValid(nx, ny) && !visited[nx][ny] && farm[nx][ny] != 'R') {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny, count + 1});
                }
            }

//            }
        }
        return 0;
    }


    static boolean isValid(int x, int y) {
        if (x >= 0 && x < 10 && y >= 0 && y < 10) return true;
        else return false;
    }
}
