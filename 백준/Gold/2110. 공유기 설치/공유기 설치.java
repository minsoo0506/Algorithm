import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N, C;
    private static int[] houses;

    public static int findMaxDistance() {
        int left = 1;
        int right = houses[N-1] - houses[0];
        int maxDistance = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int startHouse = houses[0];
            int count = 1;

            for (int i = 1; i < N; i++) {
                int distance = houses[i] - startHouse;

                if (mid <= distance) {
                    count++;
                    startHouse = houses[i];
                }
            }

            if (count >= C) {
                left = mid + 1;
                maxDistance = mid;
            } else {
                right = mid - 1;
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        houses = new int[N];

        for(int i = 0; i < N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        System.out.println(findMaxDistance());
    }
}