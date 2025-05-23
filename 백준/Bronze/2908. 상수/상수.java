import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int a = Integer.parseInt(new StringBuilder().append(st.nextToken()).reverse().toString());
        int b = Integer.parseInt(new StringBuilder().append(st.nextToken()).reverse().toString());
        int result = Math.max(a, b);
        System.out.println(result);

    }
}