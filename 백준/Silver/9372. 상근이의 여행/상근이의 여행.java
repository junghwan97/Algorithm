import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가 수 (노드 수)
            int M = Integer.parseInt(st.nextToken()); // 비행기 수 (간선 수)

            // 간선 정보 입력 (실제 그래프 사용하지 않음)
            for (int i = 0; i < M; i++) {
                br.readLine(); // u, v
            }

            // 연결된 상태에서 최소 간선 수는 N - 1
            result.append(N - 1).append("\n");
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
