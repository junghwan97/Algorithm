import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 회의 개수
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }

        // 종료 시간 기준 오름차순 정렬 (같으면 시작 시간 기준 정렬)
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // 시작 시간 기준 정렬
            }
            return a[1] - b[1]; // 종료 시간 기준 정렬
        });

        int count = 0; // 최대 회의 개수
        int lastEndTime = 0; // 마지막으로 선택된 회의의 종료 시간

        for (int[] meeting : meetings) {
            if (meeting[0] >= lastEndTime) { // 시작 시간이 직전 종료 시간 이후라면 선택
                lastEndTime = meeting[1];
                count++;
            }
        }

        System.out.println(count);
    }
}
