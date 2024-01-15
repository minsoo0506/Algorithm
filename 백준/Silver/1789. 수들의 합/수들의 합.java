import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        br.close();

        int count = 0;
        long sum = 0;
        for(int i = 1; i <= S; i++){
            sum += i;
            if (sum > S) break;
            else count++;
        }

        System.out.println(count);
    }
}