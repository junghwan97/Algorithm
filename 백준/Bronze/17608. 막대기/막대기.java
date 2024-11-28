import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine()); // 막대기 개수 N 입력
        Stack<Integer> stack = new Stack<>(); // 막대기 높이를 저장할 자료구조

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(bf.readLine()); // 막대기 높이 
            while (!stack.isEmpty() && h >= stack.peek()) stack.pop(); // 현재 값보다 작은 peek() 값 pop()
            stack.push(h);
        }
        System.out.println(stack.size());
    }
}