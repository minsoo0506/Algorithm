import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] line = new String[2];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");

            if(line[0].equals("1")){
                stack.push(Integer.parseInt(line[1]));
            } else if(line[0].equals("2")){
                if(stack.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if(line[0].equals("3")){
                sb.append(stack.size()).append("\n");
            } else if(line[0].equals("4")){
                if(stack.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                if(stack.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}