import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point{
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N;
    public static int M;

    //우 상 좌 하
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] arr, dist;
    public static boolean[][] visited;

    public static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                    dist[nx][ny] = dist[temp.x][temp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        br.close();

        dist[0][0] = arr[0][0];
        bfs(0, 0);

        System.out.println(dist[N - 1][M - 1]);
    }
}