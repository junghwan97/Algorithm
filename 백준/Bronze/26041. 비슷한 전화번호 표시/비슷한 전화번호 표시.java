import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] numA = br.readLine().split(" ");
        String numB = br.readLine();
        int count = 0;

        for (int i = 0; i < numA.length; i++) {
            if (numA[i].startsWith(numB) && !numA[i].equals(numB)) {
                count++;
            }
        }
        System.out.println(count);
    }
}