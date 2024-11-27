import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break; // 종료 조건
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                if (a == '(' || a == '[') {
                    stack.push(a);
                } else if (a == ')' || a == ']') {
                    if (stack.empty() || (a == ')' && stack.peek() != '(') || (a == ']' && stack.peek() != '[')) {
                        isBalanced = false; // 균형이 깨짐
                        break;
                    }
                    stack.pop();
                }
            }

            // 스택이 비어있고 균형이 깨지지 않은 경우 "yes"
            if (isBalanced && stack.empty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}