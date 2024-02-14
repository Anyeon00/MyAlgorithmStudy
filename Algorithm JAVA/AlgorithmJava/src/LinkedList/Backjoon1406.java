package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

// 에디터
public class Backjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        int commandN = Integer.parseInt(br.readLine());

        ListIterator<Character> it = list.listIterator();
        while(it.hasNext()){
            it.next();
        }

        for(int i = 0; i < commandN; i++){
            String command = br.readLine();
            if(command.equals("L")){
                if(it.hasPrevious()){
                    it.previous();
                }
            }else if(command.equals("D")){
                if(it.hasNext()){
                    it.next();
                }
            }else if(command.equals("B")){
                if(it.hasPrevious()){
                    it.remove();
                }
            }else{    // firstChar == P
                it.add(command.charAt(2));
            }
        }
        while(!list.isEmpty()){
            System.out.print(list.poll());
        }
    }
}
