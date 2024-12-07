import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이
        int[] trees = new int[N];
        int max = 0;
        // 주어진 나무들의 길이
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max); // 최대 높이의 나무 확인
        }

        long low = 0, high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long total = 0;
            for (int tree : trees) {
                if (tree > mid) total += (tree - mid);
            }
            if (total >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        bw.write(result + " ");
        bw.flush();
        bw.close();
    }
}
