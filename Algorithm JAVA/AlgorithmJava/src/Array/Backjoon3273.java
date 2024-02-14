package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.StringTokenizer;

//두 수의 합
public class Backjoon3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 0; i < n; i++){
            if (arr[i] != 0) {
                for (int j = 0; j < n; j++) {
                    if(arr[j] != 0 && arr[j] != arr[i]) {
                        if (arr[i] + arr[j] == x) {
                            arr[i] = 0;
                            arr[j] = 0;
                            answer++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
