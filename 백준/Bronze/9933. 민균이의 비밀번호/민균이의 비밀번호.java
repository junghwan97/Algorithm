import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 단어의 수
        HashSet<String> set = new HashSet<>(); // 뒤집은 단어랑 같은 문자열이 없으면 삽입, 있으면 꺼내서 확인

        String password = "";
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String reverse = new StringBuilder(word).reverse().toString();
            if (word.equals(reverse)) {
                password = word;
                break;
            }
            if (set.contains(reverse)) {
                password = word;
                break;
            }
            set.add(word);
        }

        int length = password.length();
        char mid = password.charAt(length / 2);
        System.out.println(length + " " + mid);

    }
}