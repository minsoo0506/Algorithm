import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] distance;
    static int goalX, goalY;

    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visit[x][y] = true;
        distance[x][y] = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Point temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(rangeCheck(nx, ny) && !visit[nx][ny] && arr[nx][ny] == 1){
                    queue.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                    distance[nx][ny] = distance[temp.x][temp.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        distance = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    goalX = i;
                    goalY = j;
                }
            }
        }

        bfs(goalX, goalY);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 0 && !visit[i][j]){
                    distance[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}