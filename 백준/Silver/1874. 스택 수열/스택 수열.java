import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int temp = 1;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            for(; temp <= num; temp++){
                stack.push(temp);
                sb.append("+\n");
            }

            if(stack.peek() == num){
                stack.pop();
                sb.append("-\n");
            }
            else{
                sb = new StringBuilder();
                sb.append("NO\n");
                break;
            }
        }

        System.out.println(sb);
    }
}