import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxHeight;
    static int countArea;
    static int[] safeArea;

    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void dfs(int x, int y, int h){
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(rangeCheck(nx, ny) && !visit[nx][ny] && arr[nx][ny] >= h){
                dfs(nx, ny, h);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        maxHeight = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight){
                    maxHeight = arr[i][j];
                }
            }
        }

        safeArea = new int[maxHeight + 1];
        for(int i = 1; i <= maxHeight; i++) {
            visit = new boolean[N][N];
            countArea = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(arr[j][k] >= i && !visit[j][k]) {
                        countArea++;
                        dfs(j, k, i);
                    }
                }
            }

            safeArea[i] = countArea;
        }

        int result = 0;
        for(int i = 1; i <= maxHeight; i++){
            result = Math.max(result, safeArea[i]);
        }

        System.out.println(result);
    }
}