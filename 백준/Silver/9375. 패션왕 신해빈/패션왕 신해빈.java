import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < test; i++) {
            int result = 1; // 경우의 수
            int n = Integer.parseInt(br.readLine()); // 한 테스트당 의상 수
            Map<String, Integer> clothset = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                clothset.put(s[1], clothset.getOrDefault(s[1], 0) + 1); // 키 : 옷 종류, 값 : 종류별 의상 수
            }
            for (Integer value : clothset.values()) {
                result *= (value + 1);
            }
            result--;
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
