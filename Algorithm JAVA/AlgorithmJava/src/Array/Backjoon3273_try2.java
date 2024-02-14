package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Backjoon3273_try2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;

        int answer = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {

                left++;
                right--;

                answer++;
            }
            if (sum > x) {
                right--;
            } else if (sum < x){
                left++;
            }
        }
        System.out.println(answer);

    }
}
