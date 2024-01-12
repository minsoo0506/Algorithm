import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static boolean[] visited;

    public static void dfs(int vertex){
        visited[vertex] = true;

        for(int i = 1; i <= N; i++){
            if(arr[vertex][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;
        int visit = 0;
        while(visit < N){
            for(int i = 1; i <= N; i++){
                if(!visited[i]){
                    dfs(i);
                    count++;
                }
            }

            for(int i = 1; i <= N; i++){
                if(visited[i] == true){
                    visit++;
                }
            }
        }

        System.out.println(count);
    }
}