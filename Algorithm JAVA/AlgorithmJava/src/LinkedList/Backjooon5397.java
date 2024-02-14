package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

//키로그
public class Backjooon5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> it = linkedList.listIterator();

            for (int j = 0; j < str.length(); j++) {
                char nowChar = str.charAt(j);
                if (nowChar == '-') {
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }//전게 없으면 백스페이스해도 아무것도 안됨
                } else if (nowChar == '<') {
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                } else if (nowChar == '>') {
                    if (it.hasNext()) {
                        it.next();
                    }
                }else {
                    it.add(nowChar);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!linkedList.isEmpty()) {
                sb.append(linkedList.poll());
            }
            System.out.println(sb);
        }

    }
}
