import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] prefix = new long[N + 1];
        
        // 배열 입력 및 누적 합 계산
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
                
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long sum = prefix[r] - prefix[l - 1];
            sb.append(sum).append('\n');
        }
        
        System.out.print(sb);
    }
}
