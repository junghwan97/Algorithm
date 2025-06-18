import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];
        
        // 1) 입력을 받아 카운팅
        for (int i = 0; i < N; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }
        
        // 2) 오름차순으로 출력
        for (int num = 1; num <= 10000; num++) {
            int cnt = counts[num];
            while (cnt-- > 0) {
                bw.write(num + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}