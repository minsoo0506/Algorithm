// 플로이드-워셜 알고리즘 : 다이나믹 프로그래밍 기법을 사용, 인접 행렬을 이용하여 각 노드간 최소 비용을 계산.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 100_000_000;
    private static int N, M;
    private static int[][] dist;
    
    // 플로이드-와샬 알고리즘
    public static void floydWarshall(){
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    // 바로 가는 것과 하나의 노드를 거쳐가는 것 중에 더 짧은 경로 저장
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                // 자기 자신에게 가는 거리는 0
                if(i == j){
                    dist[i][j] = 0;
                    continue;
                }
                // 나머지는 INF로 저장
                dist[i][j] = INF;
            }
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = 1;
        }

        floydWarshall();

        ArrayList<Integer> reps = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];

        // 각 노드에서 가장 먼 노드와의 거리가 가장 짧은 노드를 대표로 설정

        // 모든 노드 순회
        for (int i = 1; i <= N; i++) {
            // 방문하지 않은 노드만 고려 : 새로운 위원회의 대표가 될 수 있음
            if (!visited[i]) {
                // minIdx는 현재 위원회의 대표 후보
                // minVal은 해당 대표 후보에서 가장 먼 노드와의 거리
                int minIdx = i;
                int minVal = INF;
                // i와 연결된 노드 찾기
                for (int j = 1; j <= N; j++) {
                    // i와 j가 연결되어 있으면 j를 방문처리
                    if (dist[i][j] != INF) {
                        visited[j] = true;
                        int maxVal = 0;
                        // j에서 가장 먼 노드와 거리 계산
                        for (int k = 1; k <= N; k++) {
                            if (dist[j][k] != INF) {
                                maxVal = Math.max(maxVal, dist[j][k]);
                            }
                        }
                        /*
                        j에서 가장 먼 노드와의 거리가 현재 대표 후보에서 가장 먼 노드와의 거리보다
                        짧으면, j를 새로운 대표 후보로 선정
                        */
                        if (minVal > maxVal) {
                            minVal = maxVal;
                            minIdx = j;
                        }
                    }
                }
                // 모든 노드를 순회한 후, 최종 대표 후보를 위원회의 대표로 선정
                reps.add(minIdx);
            }
        }

        Collections.sort(reps);
        System.out.println(reps.size());
        for (int rep : reps) {
            System.out.println(rep);
        }
    }
}