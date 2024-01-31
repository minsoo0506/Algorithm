import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int count_5 = n / 5;
        n %= 5;

        if(n % 2 == 0){
            count = count_5 + n / 2;
        }
        else{
            if(count_5 > 0) {
                n += 5;
                count_5--;
            }
            if(n % 2 == 0){
                count = count_5 + n / 2;
            }
            else{
                count = -1;
            }
        }

        System.out.println(count);
    }
}
