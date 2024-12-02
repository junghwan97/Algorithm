import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 1차 티켓팅에서 팔린 티켓 수
        Set<Integer> seatSet = new HashSet<>();

        // 좌석 번호를 Set에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seatSet.add(Integer.parseInt(st.nextToken()));
        }

        // 빈 좌석 번호 찾기
        int smallest = 1;
        while (seatSet.contains(smallest)) {
            smallest++;
        }

        bw.write(String.valueOf(smallest));
        bw.flush();
        bw.close();
    }
}