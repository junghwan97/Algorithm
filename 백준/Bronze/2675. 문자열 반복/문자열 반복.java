import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int p = Integer.parseInt(st.nextToken());
            String[] arr = st.nextToken().split("");
            for (int j = 0; j < arr.length; j++) {
                for (int h = 0; h < p; h++) {
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }
}