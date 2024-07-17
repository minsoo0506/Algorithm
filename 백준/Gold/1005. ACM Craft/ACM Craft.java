import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, W;
    private static int[] edgeCount, cost;
    private static ArrayList<Integer>[] graph;

    // 위상정렬을 통해 W 건물을 짓기까지 걸리는 최소시간을 반환
    public static int topologicalSort(){
        int[] timeToStart = new int[N + 1]; // 각 노드에 도달하는 데 필요한 최소 시간
        Queue<Integer> q = new LinkedList<>(); // 위상 정렬에 사용할 큐

        for(int i = 1; i <= N; i++){
            if(edgeCount[i] == 0){
                q.offer(i);
                timeToStart[i] = cost[i]; // 시작 노드의 경우, 건설 시간이 시작 시간
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nextNode : graph[node]){
                edgeCount[nextNode]--; // 현재 노드에서 이동할 수 있는 다음 노드의 진입차수 감소시키기
                if(edgeCount[nextNode] == 0){ // 다음 노드의 진입차수가 0이라면 큐에 넣기
                    q.offer(nextNode);
                }
                // 다음 노드를 시작할 수 있는 최소 시간 업데이트
                timeToStart[nextNode] = Math.max(timeToStart[nextNode], timeToStart[node] + cost[nextNode]);
            }
        }

        return timeToStart[W]; // W 건물을 짓기 시작할 수 있는 최소 시간 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 건물의 개수
            K = Integer.parseInt(st.nextToken()); // 건물간의 건설순서 규칙의 총 개수

            edgeCount = new int[N + 1];
            cost = new int[N + 1];
            graph = new ArrayList[N + 1];
            for(int j = 0; j <= N; j++){
                graph[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                cost[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j <= K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph[X].add(Y);
                edgeCount[Y]++;
            }

            W = Integer.parseInt(br.readLine());

            if(edgeCount[W] == 0) bw.write(cost[W] + "\n"); // W의 진입차수가 0이라면 W 건물을 짓는데 드는 시간 비용을 바로 출력
            else {
                bw.write(topologicalSort() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}