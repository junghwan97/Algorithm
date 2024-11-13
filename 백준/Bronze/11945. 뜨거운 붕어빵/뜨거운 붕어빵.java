import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < a; i++) {
            String input = br.readLine();
            String[] arr = input.split("");
            for (int j = b - 1; j >= 0; j--) {
                String c = arr[j];
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
}