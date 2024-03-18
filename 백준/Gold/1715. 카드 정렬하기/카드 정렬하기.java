import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for(int i = 0; i < N; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while(pq.size() > 1){
            long a = pq.poll();
            long b = pq.poll();

            sum += (a + b);
            pq.offer(a + b);
        }

        System.out.println(sum);
    }
}