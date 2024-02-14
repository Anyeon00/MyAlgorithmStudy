package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            StringTokenizer st2 = new StringTokenizer(line);
            for(int j = 0; j < m; j++){
                int tmp = Integer.parseInt(st2.nextToken());
                array[i][j] = tmp;
            }
        }

        int[] bx = {1, 0, -1, 0};
        int[] by = {0, 1, 0, -1};

        int pictureN = 0;
        int biggest = 0;
        while(true){
            int startX = -1;
            int startY = -1;
            boolean sch = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(array[i][j] == 1){
                        startX = i;
                        startY = j;
                        sch = true;
                        break;
                    }
                }
                if (sch == true){
                    break;
                }
            } //그림위치 찾기
            if(startX == -1 && startY == -1){
                break;
            } //그림이 더이상 없으면 break;

            Queue<Pair> queue = new LinkedList<>();
            int biggestTmp = 0;

            queue.add(new Pair(startX, startY));
            biggestTmp++;

            while(!queue.isEmpty()){
                Pair nowPos = queue.poll();

                for(int i = 0; i < 4; i++){
                    int px = nowPos.x + bx[i];
                    int py = nowPos.y + by[i];

                    if(px < 0 || px > n-1 || py < 0 || py > m-1){
                        continue;
                    }
                    if(array[px][py] == 1){
                        queue.add(new Pair(px,py));
                        array[px][py] = 0;
                        biggestTmp++;
                    }
                }
            }
            pictureN++;
            if(biggestTmp > biggest){
                biggest = biggestTmp;
            }
        }
        System.out.println(pictureN);
        System.out.println(biggest);
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
