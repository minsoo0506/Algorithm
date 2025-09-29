import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n, k; // n은 배열의 크기, k는 찾고자 하는 인덱스
    private static int[] arr, sorted; // arr는 원본 배열, sorted는 정렬된 배열

    /**
     * 병합 정렬을 수행하는 메소드 (분할 / 병합 수행)
     * @param a 정렬하고 싶은 배열
     * @param left 배열의 시작점
     * @param right 배열의 끝점
     */
    public static void mergeSort(int[] a, int left, int right) {

        if(left == right) return; // 부분리스트가 1개의 원소만을 갖고 있는 경우

        int mid = (left + right) / 2; // 절반 위치

        mergeSort(a, left, mid); // 절반 중 왼쪽 부분 리스트 (left ~ mid)
        mergeSort(a, mid + 1, right); // 절반 중 오른쪽 부분 리스트 (mid ~ right)

        merge(a, left, mid, right); // 병합 작업
    }

    /**
     * 배열을 병합시키는 메소드
     * @param a 정렬하고 싶은 배열
     * @param left 배열의 시작점
     * @param mid 배열의 중간점
     * @param right 배열의 끝점
     */
    public static void merge(int[] a, int left, int mid, int right) {

        int l = left; // 왼쪽 부분리스트 시작점
        int r = mid + 1; // 오른쪽 부분리스트 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while(l <= mid && r <= right) {
            // 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
            // 왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            // 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
            // 오른쪽 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        // 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우
        // = 오른쪽 부분리스트 원소가 아직 남아 있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        if(l > mid) {
            while(r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        // 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우
        // = 왼쪽 부분리스트 원소가 아직 남아있을 경우
        // 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        else {
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
        for(int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sorted = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);
        bw.write(arr[k - 1] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}