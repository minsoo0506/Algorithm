import java.util.*;
import java.io.*;

public class Main {
    public static int count(int n){
        int count = 0;

        while(n >= 0){
            if(n >= 500){
                n -= 500;
                count++;
            } else if(n >= 100){
                n -= 100;
                count++;
            } else if(n >= 50){
                n -= 50;
                count++;
            } else if(n >= 10){
                n -= 10;
                count++;
            } else if(n >= 5){
                n -= 5;
                count++;
            } else {
                n -= 1;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(count(1000 - n) - 1);
    }
}