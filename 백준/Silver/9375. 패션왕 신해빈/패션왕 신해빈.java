import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int count = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int result = 1;

            for(int j = 0; j < count; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            for(int k : map.values()){
                result *= (k + 1);
            }

            sb.append(result - 1).append("\n");
        }

        System.out.print(sb);
    }
}