import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 아는 노래의 개수, M: 맞히기를 시도할 음의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashMap을 사용하여 아는 노래 데이터를 저장
        // Key: 첫 3음의 조합, Value: 노래 제목 (또는 "?"로 처리)
        Map<String, String> songMap = new HashMap<>();
        
        // 아는 노래 정보를 입력받아 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); // 제목의 길이 (사용하지 않음)
            String title = st.nextToken(); // 노래 제목
            String firstThreeNotes = st.nextToken() + st.nextToken() + st.nextToken(); // 첫 3음 추출

            // 동일한 첫 3음이 이미 존재하는 경우
            if (songMap.containsKey(firstThreeNotes)) {
                songMap.put(firstThreeNotes, "?"); // 중복이므로 "?"로 설정
            } else {
                songMap.put(firstThreeNotes, title); // 새로운 3음이면 제목 저장
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 맞히기를 시도할 음 입력받아 처리
        for (int i = 0; i < M; i++) {
            // 공백 없이 음표를 이어 붙여 검색 키 생성
            String threeNotes = br.readLine().replace(" ", "");

            // 3음을 기준으로 검색하여 결과 출력
            // 없으면 "!", 있으면 저장된 값 ("?" 또는 노래 제목) 출력
            bw.write(songMap.getOrDefault(threeNotes, "!"));
            bw.newLine();
        }

        // 출력 버퍼를 비워 결과를 출력
        bw.flush();
    }
}
