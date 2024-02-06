import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return;
        }

        int num = 1;
        int nthCircle = 2;
        while(num < N) {
            num += ((nthCircle - 1) * 6);
            nthCircle++;
        }

        System.out.println(--nthCircle);
    }
}