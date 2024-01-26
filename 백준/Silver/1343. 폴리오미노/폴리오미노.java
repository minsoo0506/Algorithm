import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        int countX = 0;

        for(int i = 0; i < str.length; i++){
            if(str[i] == 'X'){
                countX++;
            }
            else{
                if(countX % 2 != 0){
                    System.out.println(-1);
                    return;
                }
                while(countX > 0){
                    if(countX >= 4){
                        sb.append("AAAA");
                        countX -= 4;
                    }
                    else{
                        sb.append("BB");
                        countX -= 2;
                    }
                }
                sb.append(".");
            }
        }

        if(countX % 2 != 0){
            System.out.println(-1);
            return;
        }
        while(countX > 0){
            if(countX >= 4){
                sb.append("AAAA");
                countX -= 4;
            }
            else{
                sb.append("BB");
                countX -= 2;
            }
        }

        System.out.println(sb);
    }
}