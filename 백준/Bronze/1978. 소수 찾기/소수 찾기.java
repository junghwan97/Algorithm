import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) {  
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {  
                return false;
            }
        }
        return true;  
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());  
        StringTokenizer st = new StringTokenizer(br.readLine());  

        int count = 0;  
        for (int i = 0; i < a; i++) {
            int b = Integer.parseInt(st.nextToken());  
            if (isPrime(b)) {  
                count++;
            }
        }

        System.out.println(count);  
    }
}