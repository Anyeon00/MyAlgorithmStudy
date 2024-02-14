package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 스택 수열
public class Backjoon1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean b = true;

        int last = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            while (last <= input) {
                stack.push(last);
                sb.append("+\n");
                last++;
            }
            if (stack.isEmpty()) {
                System.out.println(2);
                System.out.println("NO");
                b = false;
                break;
            }
            int pop = stack.pop();
            if (pop == input) {
                sb.append("-\n");
            }else {
                System.out.println("NO");
                b = false;
                break;
            }
        }
        if (b == true) {
            System.out.println(sb);
        }
    }
}
