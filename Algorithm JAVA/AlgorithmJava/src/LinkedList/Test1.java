package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test1 {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()) {
            it.next();
        }
        it.remove();
        it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
