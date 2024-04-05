import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

// 노드에 대한 정보를 담는 클래스
class Node {
    int v;
    int cost;

    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    private static int V; // 트리의 정점의 개수
    private static ArrayList<Node>[] graph; // 그래프
    private static boolean[] visit; // 방문 여부 체크
    private static int maxDistance; // 두 점 사이의 거리 중 가장 긴 것
    private static int maxNode = 0; // 노드 1을 기준으로 가장 먼 노드

    // dfs 메소드
    private static void dfs(int node, int cost) {
        if (cost > maxDistance) {
            maxDistance = cost;
            maxNode = node;
        }
        visit[node] = true;
        for (Node n : graph[node]) {
            if (!visit[n.v]) {
                dfs(n.v, cost + n.cost);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        visit = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 사용자 입력을 바탕으로 트리 구성
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int adj = Integer.parseInt(st.nextToken());
                if (adj == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph[v].add(new Node(adj, cost));
            }
        }

        // 노드 1 에서 가장 먼 노드 찾기
        maxDistance = 0;
        dfs(1, 0);

        // 이전에 구해놓았던 maxNode에서 가장 먼 노드 찾기
        // 노드 1이 루트 노드라는 보장이 없기 때문
        visit = new boolean[V + 1];
        maxDistance = 0;
        dfs(maxNode, 0);
        System.out.println(maxDistance);
    }
}