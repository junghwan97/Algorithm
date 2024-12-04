import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 각 정수 배열의 길이
        PriorityQueue<Integer> arrA = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 저장
        PriorityQueue<Integer> arrB = new PriorityQueue<>(); // 최소 힙 저장

        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arrA.offer(Integer.parseInt(A[i]));
            arrB.offer(Integer.parseInt(B[i]));
        }

        int sum = 0;
        while (N-- > 0) {
            sum += arrA.poll() * arrB.poll();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}