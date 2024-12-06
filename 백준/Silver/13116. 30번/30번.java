import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 두 개의 정수가 주어짐
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            while (A != B) {
                if (A > B) {
                    A /= 2;
                } else {
                    B /= 2;
                }
            }
            bw.write((A * 10)+ "\n");
        }
        bw.flush();
        bw.close();
    }
}