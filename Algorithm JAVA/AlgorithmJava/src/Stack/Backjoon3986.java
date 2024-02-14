package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        풀이
//        1. Character 스택에 push
//        2. 각 A 또는 B가 꺼내진 상태면 해당 글자가 한번 더 나오면 같이 사라짐
//        3. 2에서 다른 글자가 나온 경우 실패
//        4. 모든 글자를 처리 완료 후, stack이 비어있는 경우 성공
//        5. n번 반복후 성공합계 출력
        int answer = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                stack.push(str.charAt(j));
            }
            char nowNeed = 'N';
            boolean success = true;


            int count = 0;
            while (!stack.isEmpty()) {
                System.out.println("count = " + count);
                char pop = stack.pop();
                if (pop == 'A') {
                    if (nowNeed == 'A') {
                        System.out.println(count + ", " + pop + ", " + nowNeed);
                        nowNeed = 'N';
                    } else if (nowNeed == 'B') {
                        System.out.println(count + ", " + pop + ", " + nowNeed + " break");
                        success = false;
                        break;
                    } else if (nowNeed == 'N') {
                        System.out.println(count + ", " + pop + ", " + nowNeed);
                        nowNeed = 'A';
                    }
                } else if (pop == 'B') {
                    if (nowNeed == 'B') {
                        System.out.println(count + ", " + pop + ", " + nowNeed);
                        nowNeed = 'N';
                    } else if (nowNeed == 'A') {
                        System.out.println(count + ", " + pop + ", " + nowNeed + " break");
                        success = false;
                        break;
                    } else if (nowNeed == 'N') {
                        System.out.println(count + ", " + pop + ", " + nowNeed);
                        nowNeed = 'B';
                    }
                }
            }
            if (success == true) {
                answer++;
            }
            count++;
        }
        System.out.println(answer);
    }
}
