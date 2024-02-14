package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int sticks = 0;
        int peice = 0;

        for(int i = 0; i < str.length(); i++){
            char nowChar = str.charAt(i);

            if(stack.isEmpty()){
                sticks++;
                stack.push(nowChar);
            }else{
                char peek = stack.peek();
                if(nowChar == '('){
                    // 일단 push
                    sticks++;
                    stack.push(nowChar);

                }else if(nowChar == ')'){
                    if(peek == '('){
                        // 레이저로 자른 경우
                        sticks--;
                        peice += sticks;
                        stack.push(nowChar);

                    }else if(peek == ')'){
                        // 막대기 한개-- 인 경우
                        sticks--;
                        peice++;
                        stack.push(nowChar);
                    }
                }
            }
            System.out.println("sticks = " + sticks + ", peice = " + peice);
        }
        System.out.println(peice);

    }
}
