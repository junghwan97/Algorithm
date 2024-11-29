import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> gift = new PriorityQueue<>((a, b) -> b - a); // 선물(최대 힙)

        int n = Integer.parseInt(br.readLine()); // 아이들 혹은 거점지 방문 횟수
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            if (Integer.parseInt(arr[0]) == 0 && !gift.isEmpty()) { // 0이고 선물이 있다면 선물 나눔
                bw.write(gift.peek() + "\n");
                gift.poll();
            } else if (Integer.parseInt(arr[0]) == 0 && gift.isEmpty()) { // 0이지만 선물이 없다면 -1 출력
                bw.write("-1\n");
            }
            for (int j = 1; j <= Integer.parseInt(arr[0]); j++) {
                gift.offer(Integer.parseInt(arr[j]));
            }
        }
        bw.flush();
        bw.close();
    }
}