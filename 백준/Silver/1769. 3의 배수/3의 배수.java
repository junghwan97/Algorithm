import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        int count = 0;
        while (a.length() > 1) {

            int result = 0;
            for (char s : a.toCharArray()) {
                result += s - '0';
            }
            a = String.valueOf(result);
            count++;
        }
        bw.write(count + "\n");
        if (Integer.parseInt(a) % 3 == 0) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}