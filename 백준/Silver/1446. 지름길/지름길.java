import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    int v;
    int cost;

    public Point(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] distance = new int[D + 1];
        ArrayList<Point>[] shortcut = new ArrayList[D + 1];

        for(int i = 0; i <= D; i++){
            distance[i] = i;
            shortcut[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(end <= D) {
                shortcut[start].add(new Point(end, dist));
            }
        }

        for(int i = 0; i <= D; i++){
            if(i > 0) {
                distance[i] = Math.min(distance[i], distance[i-1] + 1);
            }
            for(Point next : shortcut[i]){
                if(distance[next.v] > distance[i] + next.cost){
                    distance[next.v] = distance[i] + next.cost;
                }
            }
        }
        System.out.println(distance[D]);
    }
}