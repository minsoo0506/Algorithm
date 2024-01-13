import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static int N, M, R;
    public static ArrayList<Integer>[] graph;
    public static int[] check;
    public static int count;

    public static void dfs(int vertex){
        check[vertex] = count++;

        for(int i = 0; i < graph[vertex].size(); i++){
            if(check[graph[vertex].get(i)] == 0){
                dfs(graph[vertex].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        check = new int[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        br.close();

        for(int i = 0; i < graph.length; i++){
            Collections.sort(graph[i]);
        }

        count = 1;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < check.length; i++){
            sb.append(check[i]).append("\n");
        }

        System.out.print(sb);
    }
}