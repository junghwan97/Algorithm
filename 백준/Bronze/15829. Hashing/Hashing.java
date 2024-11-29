import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); // 문자열의 길이
        Long[] arr = new Long[L];
        int result = 0;
        String s = br.readLine();
        for (int i = 0; i < L; i++) {
            arr[i] = (long) ((s.charAt(i) - '0') - 48) * (long) Math.pow(31, i);            
            result += arr[i];
        }
        result %= 1234567891;
        System.out.println(result);
    }
}