package sort;

import java.io.*;

//요약
// pivot기준 좌우로 정렬하고, 그 좌우 각각에 대해서 반복
public class QuickSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, arr.length-1);

        printArray(arr);
    }
    private static void quickSort(int[] arr, int l, int r) {
        //Quick Sort _오른쪽 pivot기준

        //1. pivot을 정하고 (pivot = r)
        // 범위의 최좌측부터 최우측까지 traverse하며 pivot보다 작은놈을 순서대로 왼쪽에다 쌓음
        // (왼쪽부터 저장하기위해 변수 i를 둠, 저장후++)
        // 다하면 i의 다음위치와 pivot을 swap함
        // (pivot을 중심으로 왼쪽은 작은, 오른쪽은 큰놈으로 나뉨)
        //2. 그다음 그 pivot위치 기준 왼쪽에대해서(l~pivot-1) quicksort실행, 그다음 그 오른쪽에 quicksort실행
        //재귀적으로, 배열이 1개이하면 return (l이 r보다 작은동안 반복)
        if (l >= r) {
            return;
        }

        int pivot =  r; // 오른쪽 피봇
        int savePointer = l;    // 왼쪽부터 저장하기 위한 저장포인터
        for (int i = l; i < r; i++) { // 최좌측 ~ 최우측-1칸까지 _최우측이 pivot이므로
            //만약 현재칸이 pivot보다 작으면 왼쪽부터 저장
            if (arr[i] < arr[pivot]) {
                // 현재칸과 저장칸과 swap
                // arr[i] swap arr[savePointer]
                int tmp = arr[savePointer];
                arr[savePointer] = arr[i];
                arr[i] = tmp;
                savePointer++;
            }
        }   // pivot보다 작은수는 왼족에 모임
        // 젤 오른쪽에있는 pivot을 pivot보다작은수들 그 다음위치와 swap
        int tmp = arr[savePointer];
        arr[savePointer] = arr[pivot];
        arr[pivot] = tmp;

        quickSort(arr, l, savePointer - 1);   //현재 pivot 왼쪽에 대해서 quicksort
        quickSort(arr, savePointer + 1, r);  //현재 pivot 오른쪽에 대해서 quicksort

        return;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
