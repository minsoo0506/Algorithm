import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    if(o1 < o2){
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(heap.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(heap.poll()).append("\n");
                }
            } else {
                heap.offer(x);
            }
        }

        System.out.print(sb);
    }
}