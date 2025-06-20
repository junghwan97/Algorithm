import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 최대 N 값은 문제에서 1,000,000,000보다 작거나 같은 자연수지만
        // 실제 제약 조건은 N <= 100이다.
        int maxN = 100;
        long[] P = new long[maxN + 1];
        // 초기 값 설정
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        // DP 계산
        for (int i = 4; i <= maxN; i++) {
            P[i] = P[i - 2] + P[i - 3];
        }
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(P[N]).append('\n');
        }
        System.out.print(sb);
    }
}