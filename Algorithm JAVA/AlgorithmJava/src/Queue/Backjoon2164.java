package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//카드2
public class Backjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }


        while (true){
            if (queue.size() == 1) {
                break;
            }
            queue.remove();
            queue.addLast(queue.poll());
        }
        System.out.println(queue.poll());

    }
}
