import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 데이터 저장
        int[] years = new int[3]; // 입학 연도의 마지막 두 자리
        List<Member> members = new ArrayList<>(); // 문제 수와 성씨 저장

        // 입력 처리
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problems = Integer.parseInt(st.nextToken()); // 해결한 백준 문제 수
            int year = Integer.parseInt(st.nextToken()); // 입학 연도
            String surname = st.nextToken(); // 성씨

            years[i] = year % 100; // 연도 마지막 두 자리
            members.add(new Member(problems, surname));
        }

        // 첫 번째 팀명 생성: 입학 연도 오름차순
        Arrays.sort(years);
        StringBuilder yearList = new StringBuilder();
        for (int year : years) {
            yearList.append(year);
        }

        // 두 번째 팀명 생성: 문제 수 내림차순
        members.sort((a, b) -> b.problems - a.problems); // 문제 수 기준 내림차순
        StringBuilder secondName = new StringBuilder();
        for (Member member : members) {
            secondName.append(member.surname.charAt(0)); // 성씨 첫 글자만 추가
        }

        // 결과 출력
        bw.write(yearList + "\n");
        bw.write(secondName.toString());
        bw.flush();
        bw.close();
    }

    // 팀원의 정보를 저장하는 클래스
    static class Member {
        int problems; // 해결한 문제 수
        String surname; // 성씨

        Member(int problems, String surname) {
            this.problems = problems;
            this.surname = surname;
        }
    }
}