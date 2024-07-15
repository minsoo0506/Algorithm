// 외판원 순회 문제 : dp(Top-Down), 비트마스킹 사용
import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 도시의 개수
    private final static int INF = Integer.MAX_VALUE / 2;
    private static int[][] map, dp; // 도시간 연결 정보를 저장하는 배열, 최소 비용 경로를 저장하는 배열

    public static int travel(int now, int visit) {

        // 모든 도시를 방문한 경우
        if(visit == (1 << N) - 1){
            if(map[now][0] == 0) return INF; // 출발 도시로 가는 경로가 없는 경우
            else return map[now][0];
        }

        // 이미 저장되어 있는 경로인 경우
        if(dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for(int i = 0; i < N; i++){
            // 이전에 now 에서 i로 간적이 없지만, now 에서 i로 가는 경로가 있는 경우
            if((visit & (1 << i)) == 0 && map[now][i] != 0){
                // (i를 방문했다고 가정 + now 에서 i 도시까지의 거리) 와 현재까지의 최소 경로와 비교
                dp[now][visit] = Math.min(travel(i, (visit | 1 << i)) + map[now][i], dp[now][visit]);
            }
        }

        return dp[now][visit];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][(1 << N) - 1];
        for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        bw.write(travel(0, 1) + "\n");
        bw.flush();
        br.close();
    }
}