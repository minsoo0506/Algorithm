import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str[] = new String[N];

        // 문자열 입력
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        // 문자열 배열 정렬
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(str[i].length() == str[j].length()){
                    if(str[i].compareTo(str[j]) > 0){
                        String temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                    }
                }
                else {
                    if (str[i].length() > str[j].length()) {
                        String temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                    }
                }
            }
        }

        // 정렬된 문자열 출력
        for (int i = 0; i < N; i++) {
            if(i != 0){
                if(str[i].compareTo(str[i - 1]) != 0){
                    System.out.println(str[i]);
                }
            }
            else{
                System.out.println(str[i]);
            }
        }
    }
}