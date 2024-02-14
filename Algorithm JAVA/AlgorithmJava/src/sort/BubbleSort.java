package sort;

import java.io.*;
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // bubble sort
        for(int i = 0; i < n-1; i++){
            //처음~(마지막칸-1)칸까지

            //지금칸_비교_다음칸 => n-1칸, 그다음은 n-2.. 즉 n-1-i번
            for(int j = 0; j < n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
