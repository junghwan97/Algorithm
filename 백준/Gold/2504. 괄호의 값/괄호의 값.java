import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calculateValue(input));
    }

    public static int calculateValue(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;  // 최종 결과값
        int temp = 1;    // 임시 계산값

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                temp *= 2;  // 여는 괄호 '('는 2를 곱함
                stack.push(ch);
            } else if (ch == '[') {
                temp *= 3;  // 여는 괄호 '['는 3을 곱함
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;  // 스택이 비어있거나 짝이 맞지 않는 경우
                }
                if (s.charAt(i - 1) == '(') {
                    result += temp;  // 바로 닫히는 괄호라면 현재 값을 결과에 더함
                }
                stack.pop();
                temp /= 2;  // 닫는 괄호 ')'는 2로 나눔
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;  // 스택이 비어있거나 짝이 맞지 않는 경우
                }
                if (s.charAt(i - 1) == '[') {
                    result += temp;  // 바로 닫히는 괄호라면 현재 값을 결과에 더함
                }
                stack.pop();
                temp /= 3;  // 닫는 괄호 ']'는 3으로 나눔
            } else {
                return 0;  // 유효하지 않은 문자가 포함된 경우
            }
        }

        // 스택에 값이 남아있으면 올바르지 않은 문자열
        return stack.isEmpty() ? result : 0;
    }
}