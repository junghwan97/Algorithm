import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        // 일반인 기준 영역 개수 탐색
        visited = new boolean[N][N];
        int normalCount = countRegions(false);
        
        // 적록색약 기준 영역 개수 탐색
        visited = new boolean[N][N];
        int colorBlindCount = countRegions(true);
        
        System.out.println(normalCount + " " + colorBlindCount);
    }
    
    static int countRegions(boolean isColorBlind) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void bfs(int x, int y, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        char color = map[x][y];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (isSameColor(color, map[nx][ny], isColorBlind)) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    
    static boolean isSameColor(char a, char b, boolean isColorBlind) {
        if (isColorBlind) {
            if ((a == 'R' || a == 'G') && (b == 'R' || b == 'G')) return true;
        }
        return a == b;
    }
}