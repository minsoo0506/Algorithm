import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int X, Y, numSigns;
    public static int[][] positions;
    public static double[] distance;
    public static boolean[] visited;

    public static class Point implements Comparable<Point> {
        int idx;
        double cost;

        public Point(int idx, double cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point other) {
            return Double.compare(this.cost, other.cost);
        }
    }

    public static double calculateDistance(int from, int to) {
        double result = Math.sqrt(Math.pow(positions[from][0] - positions[to][0], 2) +
                         Math.pow(positions[from][1] - positions[to][1], 2));

        if (from == 0 && to == numSigns + 1) {
            return result;
        }

        if(from > 0 && from < numSigns + 1) result -= 1;
        if(to > 0 && to < numSigns + 1) result -= 1;

        return Math.max(result, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numSigns = Integer.parseInt(st.nextToken());

        positions = new int[numSigns + 2][2];
        distance = new double[numSigns + 2];
        visited = new boolean[numSigns + 2];

        for(int i = 1; i <= numSigns; i++){
            st = new StringTokenizer(br.readLine());
            positions[i][0] = Integer.parseInt(st.nextToken());
            positions[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(distance, Double.MAX_VALUE);

        positions[0] = new int[]{0, 0};
        positions[numSigns + 1] = new int[]{X, Y};

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0));
        distance[0] = 0;

        while(!pq.isEmpty()){
            Point current = pq.poll();
            int currentIndex = current.idx;

            if(visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for(int nextIndex = 0; nextIndex < numSigns + 2; nextIndex++){
                if(nextIndex == currentIndex) continue;

                double dist = calculateDistance(currentIndex, nextIndex);
                if(!visited[nextIndex] && distance[nextIndex] > distance[currentIndex] + dist){
                    distance[nextIndex] = distance[currentIndex] + dist;
                    pq.offer(new Point(nextIndex, distance[nextIndex]));
                }
            }
        }

        if (distance[numSigns + 1] == 0) {
            System.out.println(0);
        } else {
            System.out.printf("%.9f\n", distance[numSigns + 1]);
        }
    }
}