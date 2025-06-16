import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        // k, n의 최대값은 14이므로 15x15 크기로 dp 배열 선언
        int[][] dp = new int[15][15];

        // 0층 초기화
        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }

        // DP 테이블 계산
        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
            }
        }
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
