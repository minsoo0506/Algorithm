import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            deque.addLast(i);
        }

        while(deque.size() > 1){
            deque.removeFirst();
            int n = deque.removeFirst();
            deque.addLast(n);
        }

        System.out.println(deque.getFirst());
    }
}