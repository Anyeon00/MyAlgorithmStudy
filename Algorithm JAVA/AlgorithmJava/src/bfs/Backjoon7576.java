package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class Backjoon7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        // 이미 모두 익어있는 경우
        boolean otherCase = true;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0){
                    otherCase = false;
                }
                if(tmp == 1){
                    queue.add(new Pair(i,j,0));            //처음 익은 토마토들 위치 넣기
                }
                arr[i][j] = tmp;
            }
        }
        System.out.println("finished input");
        if(otherCase){
            System.out.println(0);
        }else{
            //동서남북배열

            //while(!큐.isEmpty)
            //하나꺼내기
            //for(동서남북)
            //중 위치하나 확정
            //if(boundary exception체크)
            //if(벽or방문한곳인지)
            //방문표시후 큐에 삽입

            int[] bx = {1, 0, -1, 0};
            int[] by = {0, 1, 0, -1};

            while(!queue.isEmpty()){
                Pair nowPos = queue.poll();
                int thisDate = nowPos.n + 1;

                for(int i = 0; i < 4; i++){
                    int px = nowPos.x + bx[i];
                    int py = nowPos.y + by[i];
                    if(px < 0 || px > n-1 || py < 0 || py > m-1){
                        continue;
                    }
                    if(arr[px][py] != 0){
                        continue;
                    }
                    arr[px][py] = thisDate;
                    queue.add(new Pair(px,py,thisDate));
                }
            }
            //다 돌면서 다 익었는지 + 최고 date검사

/*            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }*/

            boolean yetTomato = false;
            int finishDate = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 0){
                        yetTomato = true;
                        break;
                    }
                    if(arr[i][j] > finishDate){
                        finishDate = arr[i][j];
                    }
                }
                if(yetTomato){
                    break;
                }
            }

            if(yetTomato){
                System.out.println(-1);
            }else{
                System.out.println(finishDate);
            }
        }
    }

    static class Pair{
        int x;
        int y;
        int n;
        Pair(int x, int y, int n){
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
}
