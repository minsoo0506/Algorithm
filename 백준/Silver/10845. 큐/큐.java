import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push")){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            if(str.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(queue.poll() + " \n");
                }
            }
            if(str.equals("size")){
                sb.append(queue.size() + "\n");
            }
            if(str.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            if(str.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(queue.peek() + " \n");
                }
            }
            if(str.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    Integer last = ((LinkedList<Integer>) queue).getLast();
                    sb.append(last + " \n");
                }
            }
        }

        System.out.print(sb);
    }
}