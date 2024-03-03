import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = 1;
        int y = 1;
        for(int i = 0; i < n - 2; i++){
            int temp = y;
            y += x;
            x = temp;
        }

        System.out.println(y + " " + (n - 2));
    }
}