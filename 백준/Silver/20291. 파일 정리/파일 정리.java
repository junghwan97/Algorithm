import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> file = new HashMap<>();
  
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int n = s.indexOf(".");
            String extension = s.substring(n + 1, s.length());
            file.put(extension, file.getOrDefault(extension, 0) + 1);
        }
        Set<String> keySet = file.keySet();
        List<String> list = new ArrayList<>(keySet);
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s + " " + file.get(s));
        }
    }
}
