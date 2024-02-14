package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나중에 참고
// 퀵소트는 정렬하고 분할하여 반복하지만, 얘는 분할하고 정렬하며 다시 올라옴
// 퀵소트는 내려가면서 정렬, 얘는 올라오면서 정렬

// 반 가르고 왼쪽범위에 대해서 mergeSort후, 오른쪽범위에 대해서 mergeSort _범위의 left가 right보다 큰경우 return(boundary condition)
// 각 배열의 첫번째 index부터 비교해가며 큰쪽을 새배열에 넣음
// 각 배열중 한쪽을 다 넣었으면 다른 한쪽은 뒤에 그냥 갖다붙이기 _어차피 더 큰수들이 정렬되어 있으므로
public class MergeSortTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, arr.length-1);

        QuickSort.printArray(arr);

    }
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);


        int n1 = mid - left + 1;    //leftArray의 size
        int n2 = right - mid;       //rightArray의 size

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        //원본을 비교해서 새배열에 넣고 합치는 방법이아니라, 원본을 새배열에 넣어놓고 비교해서 원본배열에다 넣으며 하는 방법

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
