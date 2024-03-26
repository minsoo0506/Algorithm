import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int burger = 2001;
		int drink = 2001;
 
		// 버거
		for (int i = 0; i < 3; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value < burger) {	// 최솟값 찾기
				burger = value;
			}
		}
 
		// 음료
		for (int i = 0; i < 2; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value < drink) {	// 최솟값 찾기
				drink = value;
			}
		}
 
		System.out.println(burger + drink - 50);
	}
 
}