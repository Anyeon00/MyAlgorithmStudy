package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon3986_try2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<String> stack = new Stack<>();
            boolean a = false;
            boolean b = false;
            String last = "";
            for (int j = 0; j < str.length(); j++) {
                char tmp = str.charAt(i);
                if (tmp == 'A') {
                    if (a == false) {
                        a = true;
                        stack.push("AS");
                        last = "AS";
                    } else {
                        a = false;
                        stack.push("AE");
                        last = "AE";
                    }
                }
                if (tmp == 'B') {
                    if (b == false) {
                        b = true;
                        stack.push("BS");
                        last = "BS";
                    }
                    if (b == true) {
                        b = false;
                        stack.push("BE");
                        last = "BE";
                    }
                }
            }

            String prev = "";
            while (!stack.isEmpty()) {
                String now = stack.pop();
                if (now == "AS") {

                } else if (now == "AE") {

                } else if (now == "BS") {

                } else if (now == "BE") {

                }
            }
        }

    }
}
