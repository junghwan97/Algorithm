import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 단어의 수
        int count = 0; // 좋은 단어 카운트 변수

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>(); // 단어가 들어갈 자료구조(새로운 문자열마다 초기화)

            for (int j = 0; j < s.length(); j++) {
                // 현재 문자
                char a = s.charAt(j);
                // 스택이 비어있지 않거나 현재 문자가 스택의 최상단과 같을 경우
                if (!stack.empty() && a == stack.peek()) stack.pop();
                // 스택이 비어있거나 현재 문자가 스택의 최상단과 다를 경우
                else stack.push(s.charAt(j));
            }
            // 스택이 비어 있다면 좋은 단어
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}