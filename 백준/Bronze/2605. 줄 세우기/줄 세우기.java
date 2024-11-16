import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> students = new ArrayList<>();
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            students.add(students.size() - Integer.parseInt(arr[i]), i + 1);
        }
        for (Integer student : students) {
            System.out.print(student + " ");
        }
    }
}