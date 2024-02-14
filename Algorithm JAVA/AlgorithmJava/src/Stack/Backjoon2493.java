package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int topN = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < topN; i++) {
            //topInfo[0] _탑의 index, topInfo[1] _탑의 height
            int[] topInfo = new int[2];
            topInfo[0] = i+1;
            topInfo[1] = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0 ");
            }else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        break;
                    }
                    int[] receiver = stack.peek();
                    if (receiver[1] > topInfo[1]) {
                        sb.append(receiver[0] + " ");
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            stack.push(topInfo);
        }
        System.out.println(sb);
    }
}
