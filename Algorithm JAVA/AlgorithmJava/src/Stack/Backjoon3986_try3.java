package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon3986_try3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean success = true;
            boolean aStatus = false;
            boolean bStatus = false;
            for (int j = 0; j < str.length(); j++) {
                char tmp = str.charAt(i);
                if (tmp == 'A') {
                    if (aStatus == false) {
                        stack.push(tmp);
                        aStatus = true;
                    } else {
                        if (stack.peek() == 'B') {
                            success = false;
                            break;
                        }
                        stack.pop();
                        aStatus = false;
                    }
                } else if (tmp == 'B') {
                    if (bStatus == false) {
                        stack.push(tmp);
                        bStatus = true;
                    } else {
                        if (stack.peek() == 'A') {
                            success = false;
                            break;
                        }
                        stack.pop();
                        bStatus = false;
                    }
                }
            }
            if (success == true) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
