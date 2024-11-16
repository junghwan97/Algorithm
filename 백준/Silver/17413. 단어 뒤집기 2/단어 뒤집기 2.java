import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder(); // 결과 문자열
        Stack<Character> stack = new Stack<>();    // 단어를 뒤집기 위한 스택
        boolean isTag = false;                     // 태그 내부 상태 확인

        for (char c : input.toCharArray()) { // 입력 문자열을 한 글자씩 탐색
            if (c == '<') { // 태그 시작
                while (!stack.isEmpty()) { // 이전 단어 뒤집기
                    result.append(stack.pop());
                }
                isTag = true; // 태그 상태로 전환
                result.append(c); // '<' 추가
            } else if (c == '>') { // 태그 종료
                isTag = false; // 태그 상태 종료
                result.append(c); // '>' 추가
            } else if (isTag) { // 태그 내부
                result.append(c); // 태그 문자 그대로 추가
            } else if (c == ' ') { // 공백 (단어 구분)
                while (!stack.isEmpty()) { // 스택의 단어를 뒤집어서 추가
                    result.append(stack.pop());
                }
                result.append(c); // 공백 추가
            } else { // 태그 외부의 문자 (단어)
                stack.push(c); // 스택에 추가
            }
        }

        // 마지막 단어 처리 (문자열이 끝났을 때)
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result); // 결과 출력
    }
}
