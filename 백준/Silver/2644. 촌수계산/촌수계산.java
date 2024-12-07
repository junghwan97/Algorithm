import java.io.*;
import java.util.*;

public class Main {
    static class info{
        int index, count;	//현재 친척, 지나간 친척 수
        //생성자
        public info(int index, int count){
            this.index = index;
            this.count = count;
        }
    }
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited ;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 촌수라는 단위를 표현하는 독특한 문화를 가지고 있다.
        // 부모 -> 자식  1촌
        // 나와 아버지, 아버지와 할아버지는 각각 1촌
        // 나와 할아버지는 2촌이된다.
        // 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.

        // 입력
        // 사람들은 1,2,3,....n , 입력 파일의 1 -> 전체 사람의 수 n
        // 2 -> 촌수 계산 서로 다른 두 사람 번호가 주어진다.
        // 3 -> 부모 자식들 간의 관계의 개수 m,
        // 4 -> 부모 자식간의 관계를 나타내는 두번호 x,y가 각 줄에 나온다.
        // 앞으로 나오는 번호는 x, 뒤에 나오는 정수 y의 부모 번호
        int n = Integer.parseInt(br.readLine()); // 전체 사람의 수


        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 비교할 사람 1
        int b = Integer.parseInt(st.nextToken()); // 비교할 사람 2

        int m = Integer.parseInt(br.readLine()); // 부모 자식 관계의 수
//        list = new ArrayList[n +1 ];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int son = Integer.parseInt(st.nextToken());
            int parents = Integer.parseInt(st.nextToken());
            list.get(son).add(parents);
            list.get(parents).add(son);
        }
        visited = new boolean[n + 1];
        bfs(a, b); //
        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs(int start, int end) {
        Queue<info> queue = new LinkedList<>();
        visited[start] = true; // 여기서 1 -> a에 있는 value -> 2 니까 다 false처리를 해주는게

//        int depth = 0;
        queue.add(new info(start,0));
        while (!queue.isEmpty()) {
            info cur = queue.poll();


            if (cur.index == end) {
                answer = cur.count;
               break;
            }

            for (int s : list.get(cur.index)) {
                if (!visited[s]) { //
                    visited[s] = true;
                    queue.add(new info(s, cur.count+1));
                }
            }


        }
        return -1;
    }
}