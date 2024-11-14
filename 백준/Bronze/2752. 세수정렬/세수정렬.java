import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String[] arr = s.split(" ");
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(newArr);
        for (int i = 0; i < newArr.length; i++) {
            bw.write(String.valueOf(newArr[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
