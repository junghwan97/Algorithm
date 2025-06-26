import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // weight
            arr[i][1] = Integer.parseInt(st.nextToken()); // height
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i != j && arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}