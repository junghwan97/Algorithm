import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 국가 수 (노드 수)
            int M = sc.nextInt(); // 비행기 수 (간선 수)

            // 간선 정보 입력 (실제 그래프 사용하지 않음)
            for (int i = 0; i < M; i++) {
                sc.nextInt(); // u
                sc.nextInt(); // v
            }

            // 연결된 상태에서 최소 간선 수는 N - 1
            result.append(N - 1).append("\n");
        }

        System.out.print(result.toString());
        sc.close();
    }
}
