import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 버튼을 누른 횟수
//        Deque<Character> deque = new LinkedList<>(); // 문자열 저장용 Deque
        Deque<Character> deque = new ArrayDeque<>(); // 문자열 저장용 Deque
        Deque<Boolean> addedStack = new ArrayDeque<>(); // 최근 추가된 블록 추적용 Deque

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("1")) { // 문자열 맨 뒤에 블록 추가
                char block = command.charAt(2);
                deque.addLast(block); // 맨 뒤에 블록 추가
                addedStack.push(false); // 최근 추가된 블록 기록
            } else if (command.startsWith("2")) { // 문자열 맨 앞에 블록 추가
                char block = command.charAt(2);
                deque.addFirst(block); // 맨 앞에 블록 추가
                addedStack.push(true); // 최근 추가된 블록 기록
            } else if (command.startsWith("3")) { // 가장 나중에 추가된 블록 제거
                if (!addedStack.isEmpty()) {
                    // 해당 블록 제거
                    if (addedStack.pop()) deque.removeFirst(); 
                    else deque.removeLast();
                }
            }
        }
        // 최종 문자열 출력
        if (deque.isEmpty()) {
            bw.write("0");
        } else {
            for (char c : deque) {
                bw.write(c);
            }
        }
        bw.flush();
        bw.close();
    }
}