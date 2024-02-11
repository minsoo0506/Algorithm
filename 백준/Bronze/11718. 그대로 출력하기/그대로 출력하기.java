import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        while(str != null && str.length() > 0){
            sb.append(str).append("\n");
            str = br.readLine();
        }

        System.out.print(sb);
    }
}