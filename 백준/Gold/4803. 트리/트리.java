import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] tree;
    private static boolean[] visit;
    private static boolean flag;

    public static void dfs(int vertex, int parent){
        visit[vertex] = true;
        for(int i = 1; i <= n; i++){
            // 현재 정점에서 i 정점으로의 간선이 존재하는지, 다음 정점이 현재 정점의 부모 정점인지 확인
            // 자식 정점으로만 이동하기 위함
            if(tree[vertex][i] == 0 || i == parent) continue;
            // 다음 노드 i가 부모 노드가 아님에도 이미 방문한 노드라면 사이클
            if(visit[i]){
                flag = false;
                return;
            }
            dfs(i, vertex);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int caseCount = 1;

        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            tree = new int[n + 1][n + 1];
            visit = new boolean[n + 1];

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree[a][b] = tree[b][a] = 1;
            }

            int count = 0;
            for(int i = 1; i <= n; i++) {
                if(!visit[i]) {
                    flag = true;
                    dfs(i, 0);
                    if(flag) count++;
                }
            }

            sb.append("Case " + caseCount++ + ": ");
            if(count == 0){
                sb.append("No trees.\n");
            } else if(count == 1){
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of " + count + " trees.\n");
            }
        }

        System.out.println(sb);
    }
}