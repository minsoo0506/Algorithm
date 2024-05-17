// 백준 11376 열혈강호2
// 이분 매칭 : dfs(재귀)로 풀이
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M; // 직원의 수, 해야할 일의 개수
    private static int[] matchedWorker; // 일을 담당하는 사람의 번호
    private static boolean[] visit; // 방문 여부를 체크하는 배열
    private static ArrayList<Integer>[] graph; // 직원과 일의 연결 관계를 나타내는 그래프
    private static int result; // 강호네 회사에서 할 수 있는 일의 개수(최대값)

    public static boolean dfs(int worker){
        if(visit[worker]) return false; // 이미 처리된 직원이라면 false 반환
        else visit[worker] = true; // 처리되지 않은 직원이라면 true 저장 후 나머지 로직 수행

        // 각 직원이 할 수 있는 일의 번호 확인
        for(int next : graph[worker]){
            if(matchedWorker[next] == -1 || dfs(matchedWorker[next])){
                matchedWorker[next] = worker;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matchedWorker = new int[M + 1];
        graph = new ArrayList[N + 1];

        for(int i = 1; i <= M; i++ ) {
            Arrays.fill(matchedWorker, -1);
        }

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 이분 그래프 형성
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for(int j = 0; j < s; j++) {
                int taskNum = Integer.parseInt(st.nextToken());
                graph[i].add(taskNum);
            }
        }

        result = 0;
        for(int i = 1; i <= N; i++){
            // 각 직원은 최대 두 개의 일을 할 수 있기 때문에 2번 반복
            for(int j = 0; j < 2; j++) {
                visit = new boolean[N + 1];
                if (dfs(i)) {
                    result++;
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}