import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] arr;
    static StringBuilder[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine()); // 도로의 깊이
        arr = new int[(int) Math.pow(2, K) - 1]; // 깊이가 K인 완전 이진 트리의 노드 개수

        // 입력값 배열에 삽입
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            ans[i] = new StringBuilder();
        }

        solve(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++)
            bw.write(ans[i].toString() + "\n");
        bw.flush();

    }

    public static void solve(int s, int e, int floor) {

        if (floor == K) return;

        int m = (s + e) / 2;
        ans[floor].append(arr[m] + " ");

        solve(s, m - 1, floor + 1);
        solve(m + 1, e, floor + 1);
    }

}
