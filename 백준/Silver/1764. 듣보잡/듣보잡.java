import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i = 0; i < N + M; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(String key: map.keySet()){
            int value = map.get(key);
            if(value > 1){
                count++;
                sb.append(key).append("\n");
            }
        }

        System.out.println(count);
        System.out.print(sb);
    }
}
