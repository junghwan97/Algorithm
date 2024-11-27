import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 단어의 수
        int count = 0; // 좋은 단어 카운트 변수

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>(); // 단어가 들어갈 자료구조

            for (int j = 0; j < s.length(); j++) {
                if (stack.empty()) {
                    stack.push(s.charAt(j));
                } else {
                    char a = s.charAt(j);
                    if (a == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(j));
                    }
                }
            }
            // 스택이 비어 있다면 좋은 단어
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}