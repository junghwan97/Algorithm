import java.util.Scanner;

// 최고점을 기준으로 전체 점수를 다시 계산 -> 최고점 별도로 저장
// 한 과목의 점수를 계산하는 대신 한번에 계산
//(A / M * 100 + B / M * 100 + C / M * 100) / 3 => (A + B + C) * 100 / M / 3
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > max) max = A[i];
            sum = sum + A[i];
        }
        // 한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해짐
        System.out.println(sum * 100.0 / max / N);
    }
}