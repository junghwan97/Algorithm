import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> card = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            String fruit = arr[0];
            int num = Integer.parseInt(arr[1]);
            if (card.get(fruit) == null) {
                card.put(fruit, num);
            } else {
                num = card.get(fruit) + num;
                card.put(fruit, num);
            }
        }
        if (card.containsValue(5)) System.out.println("YES");
        else System.out.println("NO");
    }
}
