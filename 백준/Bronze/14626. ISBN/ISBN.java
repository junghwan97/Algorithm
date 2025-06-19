import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        // '*' 위치 찾기
        int idx = s.indexOf('*');

        // '*'를 제외한 나머지 자리의 가중합 계산
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') continue;
            int digit = c - '0';
            int weight = (i % 2 == 0) ? 1 : 3;  // 짝수 인덱스=1, 홀수 인덱스=3
            total += digit * weight;
        }

        // 손상된 자리의 가중치
        int w = (idx % 2 == 0) ? 1 : 3;

        // 0~9 중 체크섬을 맞추는 숫자 찾기
        for (int m = 0; m < 10; m++) {
            if ((total + w * m) % 10 == 0) {
                System.out.println(m);
                break;
            }
        }
    }
}
