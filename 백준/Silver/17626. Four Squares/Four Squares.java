import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static boolean isSquare(int x) {
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (isSquare(N)) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i * i < N; i++) {
            if (isSquare(N - i * i)) {
                System.out.println(2);
                return;
            }
        }

        for (int i = 1; i * i < N; i++) {
            for (int j = 1; j * j + i * i < N; j++) {
                if (isSquare(N - i * i - j * j)) {
                    System.out.println(3);
                    return;
                }
            }
        }

       
        System.out.println(4);
    }
}
