import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static int[][] chess; // 체스판
    static boolean[][] visited; // 방문 체크
    static int count = 0; // 이동 횟수
    static int[] start; // 현재 나이트가 있는 칸
    static int[] end; // 나이트가 이동하려고 하는 칸

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int i = 0; i < tc; i++) {
            size = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            chess = new int[size][size]; // 체스판 크기 설정
            visited = new boolean[size][size]; // 방문 처리 초기화

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 현재 나이트가 있는 칸 초기화
            start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            // 나이트가 이동하려고 하는 칸 초기화
            st = new StringTokenizer(br.readLine());
            end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bfs(start, end);
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int[] start, int[] end) {
        Deque<int[]> que = new LinkedList<>();
        count = 0;
        int startX = start[0];
        int startY = start[1];
        visited[startX][startY] = true;
        que.add(new int[]{startX, startY});


        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                int[] res = que.poll();
                int x = res[0];
                int y = res[1];

                if (x == end[0] && y == end[1]) return;

                for (int j = 0; j < dx.length; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (isValid(nx, ny) && !visited[nx][ny]) {
                        que.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
    }

    static boolean isValid(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) return true;
        else return false;
    }
}
