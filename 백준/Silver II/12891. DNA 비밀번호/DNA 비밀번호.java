import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        // 사용자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] DNA = {'A', 'C', 'G', 'T'};
        int[] DNA_COUNT = new int[4];
        int[] currentCount = new int[4];

        String line = br.readLine();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < S; i++){
            str.append(line.charAt(i));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            DNA_COUNT[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우 알고리즘
        int passwordCount = 0; // 비밀번호 종류의 수
        for(int i = 0; i < P; i++){
            // 문자열에 A, C, G, T가 몇개 들어있는지 currentCount 배열에 저장
            for(int j = 0; j < 4; j++){
                if(str.charAt(i) == DNA[j]){
                    currentCount[j]++;
                }
            }
        }

        for(int i = P; i <= S; i++){ // 슬라이딩을 몇번 수행할지 결정
            boolean flag = true;
            for(int j = 0; j < 4; j++){
                // 현재 비밀번호(문자열)에 필수적으로 들어있어야 하는 DNA문자의 수를 충족시키지 못하면 skip
                if(currentCount[j] < DNA_COUNT[j]){ 
                    flag = false;
                    break;
                }
            }
            // 현재 비밀번호가 조건에 충족된다면 비밀번호의 수 +1
            if(flag){
                passwordCount++;
            }
            // i가 S보다 작다면 슬라이딩 수행
            if(i < S){
                for(int j = 0; j < 4; j++){
                    // 현재 비밀번호(문자열)의 오른쪽에 있는 문자가 A, C, G, T에 해당되는지 확인
                    // 해당된다면 해당 문자 count를 +1
                    if(str.charAt(i) == DNA[j]){
                        currentCount[j]++;
                    }
                    // 현재 비밀번호(문자열)의 왼쪽에 있는 문자는 count에서 제외
                    if(str.charAt(i - P) == DNA[j]){
                        currentCount[j]--;
                    }
                }
            }
        }

        System.out.println(passwordCount);
    }
}