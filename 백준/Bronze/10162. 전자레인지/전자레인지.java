import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if(T % 10 != 0){
            System.out.println(-1);
            return;
        }

        int count_A = 0;
        int count_B = 0;
        int count_C = 0;

        count_A += T / 300;
        T %= 300;
        count_B += T / 60;
        T %= 60;
        count_C += T / 10;

        System.out.println(count_A + " " + count_B + " " + count_C);
    }
}