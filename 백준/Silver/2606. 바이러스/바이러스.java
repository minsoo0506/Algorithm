import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    public static int N, M;// 컴퓨터의 수, 컴퓨터 쌍의 수
    public static int[][] arr;// 인접 행렬
    public static boolean[] visited;// 방문 여부 체크하는 배열
    public static int count;// 웜 바이러스에 걸리게 되는 컴퓨터의 수

    // 깊이 우선 탐색(재귀 사용)
    public static void dfs(int index){
        visited[index] = true;

        for(int i = 1; i <= N; i++){
            if(arr[index][i] == 1 && !visited[i]){
                dfs(i);
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;// 상호 참조
        }

        count = 0;
        dfs(1);// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 구하기

        System.out.println(count);
    }
}