package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 11659번
public class d2_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrLength = Integer.parseInt(st.nextToken());
        int testCaseN = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        // 구간 합 배열 생성
        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArr[i] += sumArr[i-1] + arr[i];
        }


        for (int i = 0; i < testCaseN; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int firstN = Integer.parseInt(st3.nextToken());
            int secondN = Integer.parseInt(st3.nextToken());
            if (firstN - 2 < 0) {
                System.out.println(sumArr[secondN-1]);
            }else{
                System.out.println(sumArr[secondN-1] - sumArr[firstN-2]);
            }
        }

    }
}
