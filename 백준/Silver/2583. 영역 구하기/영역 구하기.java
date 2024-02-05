import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int area;
    static ArrayList<Integer> areas;

    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(rangeCheck(nx, ny) && arr[nx][ny] == 0 && !visited[nx][ny]){
                area++;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        areas = new ArrayList<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){
                    arr[j][k] = 1;
                }
            }
        }
        br.close();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] || arr[i][j] == 1) continue;
                else {
                    area = 1;
                    dfs(i, j);
                    if (area > 0) {
                        areas.add(area);
                    }
                }
            }
        }

        System.out.println(areas.size());
        Collections.sort(areas);
        for(int i = 0; i < areas.size(); i++){
            System.out.print(areas.get(i) + " ");
        }
        System.out.println();
    }
}