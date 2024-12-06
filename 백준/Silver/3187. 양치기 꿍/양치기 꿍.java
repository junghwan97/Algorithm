import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int wolf = 0;
    static int sheep = 0;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 늑대가 나타났다. 하지만 마을 사람들은 속지 않아
        // 복수심에 늑대들을 양들이 있는 울타리 안에 집어 넣어 잡아먹게 했다
        // 하지만 양들은 영역안에서 숫자가 늑대보다 많으면 늑대가 전부 잡아 먹힌다.
        // 그 외 경우는 양이 전부 잡아먹힌다.

        // 꿍은 워낙 똑똑해서 결과를 이미 알고 있다.
        // 빈공간 (.), 울타리(#), 늑대 (v), 양(k)
        // 울타리로 막히지 않은 영역에는 양과 늑대가 없다.
        // 양과 늑대는 대각선으로 이동할 수 없다.

        // 입력
        // 1 -> 세로 x 가로길이를 나타내는 두개의 정수 R,C가 주어진다.
        // 2 -> 각 줄에는 R,C개의 문자가 주어지며 이들은 위에서 설명한 기호와 동일하다.


        // 출력
        // 살아남게 되는 양과 늑대의 수를 각각 순서대로 출력한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][C];
        visited = new boolean[R][C];


        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = s.charAt(j);
            }
        }
        int totalSheep = 0;
        int totalWolves = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (field[i][j] != '#' && !visited[i][j]) {
                    sheep = 0;
                    wolf = 0;
                    bfs(i, j);
                    if (sheep > wolf) totalSheep += sheep;
                    else totalWolves += wolf;
                }
            }
        }
        bw.write(totalSheep + " " + totalWolves);
        bw.flush();
        bw.close();
    }

    // (.) 빈공간, 울타리 (#), 늑대(v), 양(k)
    static void bfs(int x, int y) {

        char a = field[x][y];
        if (a == 'k') {
            sheep++;
        } else if (a == 'v') {
            wolf++;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < R && nx >= 0 && ny < C && ny >= 0) {
                if(field[nx][ny] != '#' && !visited[nx][ny]){
                    bfs(nx, ny);
                }
            }
        }

    }
}