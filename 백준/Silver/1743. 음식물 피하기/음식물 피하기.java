import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static int N, M, K;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int area;
    public static int max;

    public static boolean rangeCheck(int x, int y){
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }

    public static void dfs(int x, int y){
        area++;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if(rangeCheck(tempX, tempY) && arr[tempX][tempY] == 1 && !visited[tempX][tempY]){
                dfs(tempX, tempY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
        }
        br.close();

        max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    area = 0;
                    dfs(i, j);
                    if(area > max){
                        max = area;
                    }
                }
            }
        }

        System.out.print(max);
    }
}