import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        String[] line = new String[2];
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");

            if(line[0].equals("push")){
                queue.offer(Integer.parseInt(line[1]));
            }
            else if(line[0].equals("pop")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.pollFirst()).append("\n");
                }
            }
            else if(line[0].equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(line[0].equals("empty")){
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            }
            else if(line[0].equals("front")){
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peekFirst()).append("\n");
                }
            }
            else {
                if(queue.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peekLast()).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}