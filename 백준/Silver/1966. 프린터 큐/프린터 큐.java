import java.io.*;
import java.util.*;

class Pair {
    int priority;
    int idx;

    public Pair(int priority, int idx) {
        this.priority = priority;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<Pair> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                q.offer(new Pair(Integer.parseInt(st.nextToken()), j));
            }

            int count = 0;

            while(!q.isEmpty()){
                Pair current = q.poll();
                boolean max = true;

                for(Pair p : q) {
                    if(p.priority > current.priority) {
                        max = false;
                    }
                }

                if(max) {
                    count++;// 출력될 때만 count를 1 증가 시킴
                    if(current.idx == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    q.offer(current);
                }
            }
        }

        System.out.print(sb);
    }
}