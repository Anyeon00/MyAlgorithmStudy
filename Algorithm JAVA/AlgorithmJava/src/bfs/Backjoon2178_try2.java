package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon2178_try2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];

        for(int i = 0; i < n; i++){
            String readArrayLine = br.readLine();
            for(int j = 0; j < m; j++){
                int tmp = readArrayLine.charAt(j) - '0';
                if(tmp == 0){
                    array[i][j] = -1;
                }else if(tmp == 1){
                    array[i][j] = 0;
                }

            }
        }

        //bfs
        //동서남북배열
        //원본배열
        int[] bx = {1, 0, -1, 0};
        int[] by = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();

        //첫번째 집어넣기
        queue.add(new Pair(0,0,1));
        array[0][0] = 1;

        //while(큐가 빌때까지)
        //첫번째 element pop
        //for(동,서,남,북)
        //if(boundary exception테스트)
        //if(벽or방문한곳 아닌지)
        //방문후, 큐에 push


        // 벽은 -1, 길은 0, 방문한곳은 1~n
        while(!queue.isEmpty()){

            //현재위치
            Pair nowPos = queue.poll();
            //현재위치의 거리
            int dis = nowPos.distance + 1;

            for(int i = 0; i < 4; i++){
                int px = nowPos.x + bx[i];
                int py = nowPos.y + by[i];

                if(px < 0 || px > n-1 || py < 0 || py > m-1){
                    continue;
                }
                if(array[px][py] == 0){
                    array[px][py] = dis;
                    queue.add(new Pair(px, py, dis));
                }
            }
        }
        System.out.println(array[n-1][m-1]);
    }

    static class Pair{
        int x;
        int y;
        int distance;
        public Pair(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
