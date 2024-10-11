import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int num = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                num -= 1;
            }
        }
        System.out.println(num);
    }
}