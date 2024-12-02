import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 학교 수
            List<School> school = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                school.add(new School(st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            school.sort(Comparator.comparing(School::getAlcohol).reversed());
            bw.write(school.get(0).name + "\n");
        }
        bw.flush();
        bw.close();

    }

    static class School  {
        String name;
        int alcohol;

        public School(String name, int alcohol) {
            this.name = name;
            this.alcohol = alcohol;
        }

        public int getAlcohol() {
            return alcohol;
        }
    }
}
