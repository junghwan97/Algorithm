import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            System.out.println(isPalindrome(s) + " " + count);
            count = 0;
        }
    }

    private static int isPalindrome(String[] s) {
        return recursion(s, 0, s.length - 1);
    }

    private static int recursion(String[] s, int i, int r) {
        count++;
        if (i >= r) return 1;
        else if (!s[i].equals(s[r])) return 0;
        else return recursion(s, i + 1, r - 1);
    }
}