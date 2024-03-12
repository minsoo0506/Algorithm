import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        while(!input.equals(".")){
            Stack<Character> braket = new Stack<>();
            char[] line = input.toCharArray();
            boolean isBalanced = true;
            for(int i = 0; i < line.length; i++){
                if(line[i] == '('){
                    braket.push('(');
                } else if(line[i] == ')'){
                    if(braket.isEmpty() || braket.peek() != '('){
                        isBalanced = false;
                        break;
                    } else {
                        braket.pop();
                    }
                } else if(line[i] == '['){
                    braket.push('[');
                } else if(line[i] == ']'){
                    if(braket.isEmpty() || braket.peek() != '['){
                        isBalanced = false;
                        break;
                    } else {
                        braket.pop();
                    }
                }
            }

            if(!braket.isEmpty() || !isBalanced){
                sb.append("no\n");
            } else {
                sb.append("yes\n");
            }

            input = br.readLine();
        }

        System.out.print(sb);
    }
}