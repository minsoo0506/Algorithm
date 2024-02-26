import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] depth;

    static void dfs(int start){
        for(int v : graph[start]){
            if(depth[v] == -1){
                depth[v] = depth[start] + 1;
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        depth = new int[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            depth[i] = -1;
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        br.close();

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        depth[R] = 0;
        dfs(R);

        for(int i = 1; i <= N; i++){
            System.out.println(depth[i]);
        }
    }
}