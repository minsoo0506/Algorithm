import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long R = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());
        
        long result = (long)Math.ceil((double)R/(double)N) * (long)Math.ceil((double)C/(double)N);
        System.out.println(result);
    }
}