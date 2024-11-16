import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String bestSeller;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            books.put(book, books.getOrDefault(book, 0) + 1);
        }
        int max = 0;
        List<String> list = new ArrayList<>(books.keySet());
        Collections.sort(list);
        for (String s : list) {
            if (books.get(s) > max) {
                max = books.get(s);
                bestSeller = s;
            }
        }
        System.out.println(bestSeller);
    }
}
