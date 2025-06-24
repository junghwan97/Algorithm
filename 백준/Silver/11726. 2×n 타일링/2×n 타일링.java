import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        // dp[i]: 2×i 직사각형을 채우는 경우의 수
        int[] dp = new int[n + 1];
        
        // 초기값 설정
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }

        // 점화식 적용
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
