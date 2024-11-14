import java.util.Scanner;

public class Main {
    static int recursiveCount = 0; // 재귀 호출 횟수를 기록할 변수
    static int dpCount = 0; // DP 호출 횟수를 기록할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fibonacciRecursive(n);
        fibonacciDP(n);

        System.out.print(recursiveCount + " " + dpCount);
    }

    // 재귀 방식으로 피보나치 수열 계산
    public static int fibonacciRecursive(int n) {
        if (n == 1 || n == 2) { 
            recursiveCount++; // 호출 횟수 기록
            return 1; // F(1)과 F(2)는 1로 정의
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    // DP 방식으로 피보나치 수열 계산
    public static int fibonacciDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1; // F(1)과 F(2)를 초기화
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 이전 두 값을 더해서 dp[i] 저장
            dpCount++; // 계산 횟수 기록
        }
        return dp[n];
    }
}