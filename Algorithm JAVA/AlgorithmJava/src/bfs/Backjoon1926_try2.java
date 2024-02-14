package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1926_try2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 동서남북배열
        int[] bx = {1, 0, -1, 0};
        int[] by = {0, 1, 0, -1};

        int pictureN = 0;
        int biggest = 0;

        while (true) {
            Pair startPos = null;
            boolean foundPicture = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        startPos = new Pair(i, j);
                        foundPicture = true;
                        break;
                    }
                }
                if (foundPicture) {
                    break;
                }
            }
            if (!foundPicture){
                break;
            }
            pictureN++;

            Queue<Pair> queue = new LinkedList<>();
            int thisSize = 0;
            // 첫번째주입
            arr[startPos.x][startPos.y] = 0;
            queue.add(startPos);
            thisSize++;

            // while(!empty)
            // queue.pop
            // for(동서남북)
            // if(boundary exception check)
            // if(방문했던곳 or 벽인지)
            // 체크 & push
            while (!queue.isEmpty()) {
                Pair nowPos = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int px = nowPos.x + bx[i];
                    int py = nowPos.y + by[i];

                    if (px < 0 || px > n - 1 || py < 0 || py > m - 1) {
                        continue;
                    }
                    if (arr[px][py] == 1) {
                        queue.add(new Pair(px, py));
                        arr[px][py] = 0;
                        thisSize++;
                    }
                }
            }

            if (thisSize > biggest) {
                biggest = thisSize;
            }
        }

        System.out.println(pictureN);
        System.out.println(biggest);

    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
