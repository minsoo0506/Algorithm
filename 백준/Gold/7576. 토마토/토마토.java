import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int M, N;
    static int[][] box;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static boolean rangeCheck(int x, int y){
        if(x >= 0 && x < N && y >= 0 && y < M){
            if(box[x][y] == 0){
                return true;
            }
        }
        return false;
    }

    public static int bfs(){
        while (!queue.isEmpty()){
            Point temp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(rangeCheck(nx, ny)){
                    box[nx][ny] = box[temp.x][temp.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        int day = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0){
                    return -1;
                }
                day = Math.max(day, box[i][j]);
            }
        }

        return day == 1 ? 0 : day - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.offer(new Point(i, j));
                }
            }
        }

        System.out.println(bfs());
    }
}