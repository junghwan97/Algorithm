import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String arr[] = s.split(" ");
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int num  = Integer.parseInt(arr[i]);
            sum += num * num;
        }
        bw.write(String.valueOf(sum % 10));
        bw.flush();
        bw.close();
    }
}