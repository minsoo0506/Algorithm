import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][] visit;

    public static boolean rangeCheck(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static int bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visit[x][y] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        while(!queue.isEmpty()){
            Point temp = queue.poll();

            for(int k = 0; k < 4; k++){
                int nx = temp.x + dx[k];
                int ny = temp.y + dy[k];

                if(rangeCheck(nx, ny) && arr[nx][ny] != 'X' && !visit[nx][ny]){
                    if(arr[nx][ny] == 'P'){
                        count++;
                    }

                    visit[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new boolean[N][M];
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = bfs(startX, startY);
        System.out.println(result > 0 ? result : "TT");
    }
}