package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] array = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                char element = line.charAt(j);
                if(element == '1'){
                    array[i][j] = false;
                }else if(element == '0'){
                    array[i][j] = true;
                }
            }
        }
        //입력 완료

        // bfs로 탐색
        // 0, 1, -1, 0 배열만들기
        int[] bx = {1, 0, -1, 0};
        int[] by = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();

        // 첫번째 넣기
        array[0][0] = true;
        queue.add(new Pair(0,0));

        // while(!큐.isEmpty())
        // element pop
        // for(4방향)
        // exception검사
        // 방문or벽 검사
        // 방문후 push
        int answer = 1;
        boolean rere = false;
        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int px = cur.x + bx[i];
                int py = cur.y + by[i];
                if(px < 0 || px > n-1 || py < 0 || py > m-1){
                    continue;
                }
                if(array[px][py] != true){
                    queue.add(new Pair(px, py));
                    answer++;
                    if(px == n-1 && py == m-1){
                        rere = true;
                        break;
                    }
                    array[px][py] = true;
                    System.out.println("px = " + px + " py = " + py);
                }
            }
            if(rere == true){
                break;
            }
        }

        System.out.println(answer);

    }

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
