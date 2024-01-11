import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static int N, M, V;
    public static int[][] arr;
    public static boolean[] visited;
    public static Queue<Integer> queue;
    public static StringBuilder sb;

    public static void bfs(int start){
        queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");

            for(int i = 1; i <= N; i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int index){
        visited[index] = true;
        sb.append(index).append(" ");

        for(int i = 1; i <= N; i++){
            if(arr[index][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        br.close();

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];

        bfs(V);
        sb.append("\n");

        System.out.print(sb);
    }
}