import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count[] = new int[N + 1];

        if(N == 1) count[1] = 0;
        else if(N == 2) count[2] = 1;
        else if(N == 3) count[3] = 1;
        else {
            count[1] = 0;
            count[2] = 1;
            count[3] = 1;
            for (int i = 4; i <= N; i++) {
                if(i % 6 == 0){
                    count[i] = Math.min(Math.min(count[i - 1], count[i / 3]), count[i / 2]) + 1;
                }
                else if(i % 3 == 0){
                    count[i] = Math.min(count[i - 1], count[i / 3]) + 1;
                }
                else if(i % 2 == 0){
                    count[i] = Math.min(count[i - 1], count[i / 2]) + 1;
                }
                else{
                    count[i] = count[i - 1] + 1;
                }
            }
        }

        System.out.println(count[N]);
    }
}