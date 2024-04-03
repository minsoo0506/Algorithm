// 플로이드-워셜 알고리즘 : 다이나믹 프로그래밍 기법을 사용, 인접 행렬을 이용하여 각 노드간 최소 비용을 계산.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final int INF = 100_000_000;
    private static int N, M;
    private static int[][] dist;
    private static boolean[] visited;

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

    public static int findLeader(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(start);

        // BFS (분리 집합(arrayList에 저장) 만들기)
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 1; i <= N; i++){
                if(dist[now][i] != INF && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                    arrayList.add(i);
                }
            }
        }

        // 플로이드-와샬 알고리즘 수행
        floydWarshall();

        // 의사 전달 시간의 최대값이 최소인 값 찾기
        int index = -1;
        int minCost = INF;

        for(int i = 1; i <= N; i++){
            if(!arrayList.contains(i)){
                continue;
            }

            int maxCost = 0;
            for(int j = 1; j <= N; j++){
                if(!arrayList.contains(j)){
                    continue;
                }
                
                maxCost = Math.max(maxCost, dist[i][j]);
            }

            if(minCost > maxCost){
                minCost = maxCost;
                index = i;
            }
        }

        return index;
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

            // 양방향 인접 행렬
            dist[a][b] = dist[b][a] = 1;
        }

        visited = new boolean[N + 1];
        ArrayList<Integer> leaders = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                leaders.add(findLeader(i));
            }
        }

        Collections.sort(leaders);
        System.out.println(leaders.size());
        for (int leader : leaders) {
            System.out.println(leader);
        }
    }
}
