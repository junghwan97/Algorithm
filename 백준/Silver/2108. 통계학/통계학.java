import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        // 1. 산술평균
        int avg = (int) Math.round((double) sum / N);
        bw.write(avg + "\n");

        // 2. 중앙값
        Arrays.sort(arr);
        int middle = arr[N / 2];
        bw.write(middle + "\n");

        // 3. 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                modes.clear();
                modes.add(num);
            } else if (freq == maxFreq) {
                modes.add(num);
            }
        }

        Collections.sort(modes);
        int mode = (modes.size() > 1) ? modes.get(1) : modes.get(0);
        bw.write(mode + "\n");
        // 4. 범위
        int range = arr[N - 1] - arr[0];
        bw.write(range + "\n");

        // 결과 출력
        bw.flush();
        bw.close();
    }
}
