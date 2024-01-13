import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m,  person1, person2;
    public static int[][] arr;
    public static boolean[] visited;
    public static Integer relatives;

    public static void dfs(int current, int end, int depth){
        visited[current] = true;

        if(current == end){
            relatives = depth;
            return;
        }

        for(int i = 1; i <= n; i++){
            if(arr[current][i] == 1 && !visited[i]){
                dfs(i, end, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        br.close();

        dfs(person1, person2, 0);

        int result = (relatives == null) ? -1 : relatives;
        System.out.println(result);
    }
}