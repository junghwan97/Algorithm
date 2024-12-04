import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        while (T-- > 0) {
            // 테스트 케이스 시작
            int N = Integer.parseInt(br.readLine()); // 지원자 수
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 서류 등수
                arr[i][1] = Integer.parseInt(st.nextToken()); // 면점 등수
            }
            // 서류 점수 기준으로 오름차순 정렬
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 1; // 첫 번째 지원자는 무조건 채용
            int minInterviewRank = arr[0][1]; // 첫 번째 지원자의 면접 점수

            for (int j = 1; j < N; j++) {
                // 면접 점수가 현재까지의 최소 점수보다 낮은 경우 채용
                if (arr[j][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = arr[j][1]; // 최소값 갱신
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
