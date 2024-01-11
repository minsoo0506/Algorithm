import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int w, h;
    public static int[][] arr;
    public static boolean[][] visited;

    // 우, 우상, 상, 좌상, 좌, 좌하, 하, 우하
    public static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean rangeCheck(int x, int y){
        return (x >= 0 && x < h && y >= 0 && y < w) ? true : false;
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(rangeCheck(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        br.close();
        System.out.print(sb);
    }
}