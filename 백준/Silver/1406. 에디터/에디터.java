import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            left.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            char[] command = br.readLine().toCharArray();

            if(command[0] == 'L'){
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            } else if(command[0] == 'D'){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            } else if(command[0] == 'B'){
                if(!left.isEmpty()){
                    left.pop();
                }
            } else if(command[0] == 'P'){
                left.push(command[2]);
            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}