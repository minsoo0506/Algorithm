// 백준 2188 축사 배정
// 이분 매칭 : dfs(재귀)로 풀이
import java.io.*;
import java.util.*;

public class Main {
    private static int N, M; // 소의 수, 축사의 수
    private static int[] matchedCow; // 축사에 들어간 소의 번호
    private static boolean[] visit; // 방문 여부를 체크하는 배열
    private static ArrayList<Integer>[] graph; // 소와 축사의 연결 관계를 나타내는 그래프
    private static int result; // 축사에 들어갈 수 있는 소의 최댓값

    public static boolean dfs(int cowNum){
        if(visit[cowNum]) return false; // 이미 처리된 소라면 false 반환
        else visit[cowNum] = true; // 처리되지 않은 소라면 true 저장 후 나머지 로직 수행

        // cowNum번 소가 들어가고 싶어하는 축사 확인
        for(int next : graph[cowNum]){
            // 아직 소가 들어가 있지 않은 축사거나 이미 들어가 있는 소가 다른 축사로 옮겨질 수 있는 경우
            // (축사를 양보해 줄 수 있는 경우)
            if(matchedCow[next] == -1 || dfs(matchedCow[next])){
                matchedCow[next] = cowNum;
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
        matchedCow = new int[M + 1];
        graph = new ArrayList[N + 1];

        Arrays.fill(matchedCow, -1);

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 이분 그래프 형성
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for(int j = 0; j < s; j++) {
                int barnNum = Integer.parseInt(st.nextToken());
                graph[i].add(barnNum);
            }
        }

        result = 0;
        for(int i = 1; i <= N; i++){
            visit = new boolean[N + 1];
            if(dfs(i)){
                result++;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}