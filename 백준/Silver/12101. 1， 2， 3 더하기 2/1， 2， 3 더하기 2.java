import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] list = new ArrayList[n + 3];
        for(int i = 0; i < n + 3; i++){
            list[i] = new ArrayList<>();
        }

        list[1].add("1");
        list[2].add("1+1");
        list[2].add("2");
        list[3].add("1+1+1");
        list[3].add("1+2");
        list[3].add("2+1");
        list[3].add("3");

        for(int i = 4; i <= n; i++){
            for(int j = 1; j <= 3; j++){
               for(String str : list[i - j]){
                   list[i].add(str + "+" + j);
               }
            }
        }

        if(list[n].size() < k){
            System.out.println(-1);
        }
        else{
            Collections.sort(list[n]);
            System.out.println(list[n].get(k - 1));
        }
    }
}