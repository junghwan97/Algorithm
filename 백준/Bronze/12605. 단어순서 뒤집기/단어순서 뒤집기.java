import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                stack.push(s[j]);
            }
            System.out.print("Case #" + i + ": ");
            for (int k = 0; k < s.length; k++) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

    }
}    