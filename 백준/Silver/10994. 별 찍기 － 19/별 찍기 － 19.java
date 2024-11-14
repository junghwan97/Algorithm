import java.io.*;

public class Main {
    static char star[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
                
        n = 4 * n - 3; //가로 세로의 출력
        star = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }

        draw(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void draw(int s, int len) {
        if (len<=s) return;

        for (int i = s; i < len; i++) {
            star[s][i] = '*'; //맨 위 가로줄
            star[len - 1][i] = '*'; //맨 아래 가로줄
            star[i][s] = '*'; //왼쪽 세로줄
            star[i][len - 1] = '*'; //오른쪽 세로줄
        }


        // 별을 좌표라고 생각할 때 겉테두리의 사각형과 가장 근접한 사각형을 보았을 때 시작 인덱스가 2만큼의 차이가 난다
        draw(s + 2, len - 2);
    }
}
