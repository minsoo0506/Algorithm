import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push_front")){
                deque.offerFirst(Integer.parseInt(st.nextToken()));
            }
            if(str.equals("push_back")){
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }
            if(str.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(deque.pollFirst() + " \n");
                }
            }
            if(str.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(deque.pollLast() + " \n");
                }
            }
            if(str.equals("size")){
                sb.append(deque.size() + "\n");
            }
            if(str.equals("empty")){
                if(deque.isEmpty()){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            if(str.equals("front")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.peekFirst() + " \n");
                }
            }
            if(str.equals("back")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.peekLast() + " \n");
                }
            }
        }

        System.out.print(sb);
    }
}
